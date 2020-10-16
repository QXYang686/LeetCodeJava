package problem563;

import common.TreeNode;
import common.TreeUtil;

public class Solution1 {
    private int ans = 0;

    public int findTilt(TreeNode root) {
        sum(root);
        return ans;
    }

    private int sum(TreeNode root) {
        if (root == null) return 0;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        ans += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().findTilt(TreeUtil.buildTree(new Integer[]{
                1, 2, 3
        }))); // 1
    }
}
