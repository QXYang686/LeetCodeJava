package problem100;

import common.TreeNode;
import common.TreeUtil;

public class Solution1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().isSameTree(
                TreeUtil.buildTree(new Integer[]{1,2,3}),
                TreeUtil.buildTree(new Integer[]{1,2,3})
        )); // true
        System.out.println(new Solution1().isSameTree(
                TreeUtil.buildTree(new Integer[]{1,2}),
                TreeUtil.buildTree(new Integer[]{1,null,2})
        )); // false
        System.out.println(new Solution1().isSameTree(
                TreeUtil.buildTree(new Integer[]{1,2,1}),
                TreeUtil.buildTree(new Integer[]{1,1,2})
        )); // false
    }
}
