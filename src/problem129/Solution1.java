package problem129;

import common.TreeNode;
import common.TreeUtil;

public class Solution1 {
    private int ans = 0;

    private void dfs(TreeNode root, int value) {
        if (root == null) return;
        if (root.left == null && root.right == null) ans += (value * 10 + root.val);
        dfs(root.left, value * 10 + root.val);
        dfs(root.right, value * 10 + root.val);
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().sumNumbers(TreeUtil.buildTree(new Integer[]{1,2,3}))); // 25
        System.out.println(new Solution1().sumNumbers(TreeUtil.buildTree(new Integer[]{4,9,0,5,1}))); // 1026
    }
}
