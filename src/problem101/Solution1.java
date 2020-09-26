package problem101;

import common.TreeNode;
import common.TreeUtil;

public class Solution1 {
    /**
     * 递归方法
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricSame(root.left, root.right);
    }

    private boolean isSymmetricSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSymmetricSame(p.left, q.right) && isSymmetricSame(p.right, q.left);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().isSymmetric(TreeUtil.buildTree(new Integer[]{1,2,2,3,4,4,3}))); // true
        System.out.println(new Solution1().isSymmetric(TreeUtil.buildTree(new Integer[]{1,2,2,null,3,null,3}))); // false
    }
}
