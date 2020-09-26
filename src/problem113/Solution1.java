package problem113;

import common.TreeNode;
import common.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    private List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, path, sum);
        return ans;
    }

    private void dfs(TreeNode root, LinkedList<Integer> path, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                path.addLast(root.val);
                ans.add(new ArrayList<>(path));
                path.removeLast();
            }
            return;
        }
        path.addLast(root.val);
        dfs(root.left, path, sum - root.val);
        dfs(root.right, path, sum - root.val);
        path.removeLast();
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,null,5,1});
        System.out.println(new Solution1().pathSum(root, 22)); // [[5,4,11,2],[5,8,4,5]]
    }
}
