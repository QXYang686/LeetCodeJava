package problem437;

import common.TreeNode;
import common.TreeUtil;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    private int ans;

    public int pathSum(TreeNode root, int sum) {
        availablePathSum(root, sum);
        return ans;
    }

    private List<Integer> availablePathSum(TreeNode root, int sum) {
        LinkedList<Integer> availablePathSums = new LinkedList<>();
        if (root == null) return availablePathSums;
        List<Integer> leftAvailable = availablePathSum(root.left, sum);
        List<Integer> rightAvailable = availablePathSum(root.right, sum);
        leftAvailable.forEach(pathSum -> {
            availablePathSums.add(pathSum + root.val);
            if (pathSum + root.val == sum) ans++;
        });
        rightAvailable.forEach(pathSum -> {
            availablePathSums.add(pathSum + root.val);
            if (pathSum + root.val == sum) ans++;
        });
        availablePathSums.add(root.val);
        if (root.val == sum) ans++;
        return availablePathSums;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().pathSum(TreeUtil.buildTree(new Integer[]{
                10,5,-3,3,2,null,11,3,-2,null,1
        }), 8));
    }
}
