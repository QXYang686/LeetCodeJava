package problem538;

import common.TreeNode;
import common.TreeUtil;

import java.util.Arrays;

public class Solution1 {
    private int sum = 0;

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        root.val = sum = sum + root.val;
        dfs(root.left);
    }

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TreeUtil.buildArray(new Solution1().convertBST(TreeUtil.buildTree(new Integer[]{5, 2, 13}))))); // [18,20,13]
        System.out.println(Arrays.toString(TreeUtil.buildArray(new Solution1().convertBST(TreeUtil.buildTree(new Integer[]{4,2,6,1,3,5}))))); // [
    }
}
