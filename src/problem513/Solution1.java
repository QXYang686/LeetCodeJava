package problem513;

import common.TreeNode;
import common.TreeUtil;

public class Solution1 {
    private int maxLevel = 0;
    private int ans = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) return;
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
        if (level > maxLevel) {
            maxLevel = level;
            ans = root.val;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().findBottomLeftValue(TreeUtil.buildTree(new Integer[]{
                2, 1, 3
        })));
        System.out.println(new Solution1().findBottomLeftValue(TreeUtil.buildTree(new Integer[]{
                1, 2, 3, 4, null, 5, 6, null, null, null, null, 7
        })));
    }
}
