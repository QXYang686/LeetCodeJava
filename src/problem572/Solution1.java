package problem572;

import common.TreeNode;
import common.TreeUtil;

public class Solution1 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;
        if (s.val == t.val && isSameTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        else if (s != null && t != null) return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().isSubtree(
                TreeUtil.buildTree(new Integer[]{
                        3, 4, 5, 1, 2
                }),
                TreeUtil.buildTree(new Integer[]{
                        4, 1, 2
                })
        )); // true
        System.out.println(new Solution1().isSubtree(
                TreeUtil.buildTree(new Integer[]{
                        3, 4, 5, 1, 2, null, null, null, null, 0
                }),
                TreeUtil.buildTree(new Integer[]{
                        4, 1, 2
                })
        )); // false
        System.out.println(new Solution1().isSubtree(
                TreeUtil.buildTree(new Integer[]{
                        1, 1
                }),
                TreeUtil.buildTree(new Integer[]{
                        1
                })
        )); // true
    }
}
