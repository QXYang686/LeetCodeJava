package problem222;

import common.TreeNode;
import common.TreeUtil;

public class Solution1 {
    private int maxLevel = 0;
    private int ans = 0;

    private boolean dfs(TreeNode root, int level) {
        if (root == null) return false;
        // 非底层叶节点,结束遍历
        if (root.left == null && root.right == null && level < maxLevel) return true;
        // 底层叶节点,记录
        if (root.left == null && root.right == null) {
            maxLevel = level;
            ans++;
        }
        // 遍历
        if (dfs(root.left, level + 1)) return true;
        if (dfs(root.right, level + 1)) return true;
        return false;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return (1 << (maxLevel - 1)) - 1 + ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().countNodes(TreeUtil.buildTree(new Integer[]{1,2,3,4,5,6}))); // 6
    }
}
