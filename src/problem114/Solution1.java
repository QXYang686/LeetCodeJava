package problem114;

import common.TreeNode;
import common.TreeUtil;

public class Solution1 {
    /**
     * Wrong Answer, 顺序与题设不一致
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode last = root, cur = root;
        do {
            while (last.right != null) last = last.right;
            last.right = cur.left;
            cur.left = null;
            cur = cur.right;
        } while (cur.right != null);
    }

    public static void main(String[] args) {
        new Solution1().flatten(TreeUtil.buildTree(new Integer[]{
                1,
                2, 5,
                3, 4, null, 6
        }));
    }
}
