package problem110;

import common.TreeNode;
import common.TreeUtil;

public class Solution2 {
    private int height(TreeNode root) {
        if (root ==  null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.abs(left - right) <= 1 && left != -1 && right != -1 ? Math.max(left, right) + 1 : -1;
    }

    /**
     * 利用后续遍历实现自底向上
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isBalanced(TreeUtil.buildTree(new Integer[]{
                3,
                9, 20,
                null, null, 15, 7
        }))); // true
        System.out.println(new Solution2().isBalanced(TreeUtil.buildTree(new Integer[]{
                1,
                2, 2,
                3, 3, null, null,
                4, 4
        }))); // false
    }
}
