package problem114;

import common.TreeNode;
import common.TreeUtil;

public class Solution2 {
    private TreeNode preNode = null;

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        dfs(root.left);
        root.left = null;
        root.right = preNode;
        preNode = root;
    }

    /**
     * 反向后续遍历，空间复杂度O(logn)
     * @param root
     */
    public void flatten(TreeNode root) {
        dfs(root);
    }

    public static void main(String[] args) {
        new Solution2().flatten(TreeUtil.buildTree(new Integer[]{
                1,
                2,5,
                3,4,null,6
        }));
    }
}
