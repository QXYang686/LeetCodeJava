package problem98;

import common.TreeNode;
import common.TreeUtil;

public class Solution1 {
    private Integer value = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (value != null && root.val <= value) return false;
        value = root.val;
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().isValidBST(TreeUtil.buildTree(new Integer[]{2,1,3}))); // true
        System.out.println(new Solution1().isValidBST(TreeUtil.buildTree(new Integer[]{5,1,4,null,null,3,6}))); // false
    }
}
