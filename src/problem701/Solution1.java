package problem701;

import common.TreeNode;
import common.TreeUtil;

import java.util.Arrays;

public class Solution1 {
    private void insert(TreeNode root, int val) {
        if (val > root.val && root.right != null) insert(root.right, val);
        if (val > root.val && root.right == null) root.right = new TreeNode(val);
        if (val < root.val && root.left != null) insert(root.left, val);
        if (val < root.val && root.left == null) root.left = new TreeNode(val);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        insert(root, val);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TreeUtil.buildArray(new Solution1().insertIntoBST(TreeUtil.buildTree(new Integer[]{
                4,
                2, 7,
                1, 3
        }), 5))));
    }
}
