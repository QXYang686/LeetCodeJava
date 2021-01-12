package interview04_04;

import common.TreeNode;

public class Solution1 {
    public boolean isBalanced(TreeNode root) {
        if (null == root) return true;
        int[] ans = heightAndBalanced(root);
        return ans[1] != 0;
    }

    private int[] heightAndBalanced(TreeNode node) {
        if (node == null) return new int[]{0, 1};
        int[] left = heightAndBalanced(node.left);
        if (left[1] == 0) return new int[]{0, 0};
        int[] right = heightAndBalanced(node.right);
        if (right[1] == 0) return new int[]{0, 0};
        return new int[]{Math.max(left[0], right[0]) + 1, Math.abs(left[0] - right[0]) <= 1 ? 1 : 0};
    }
}
