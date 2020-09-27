package problem111;

import common.TreeNode;
import common.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    private int ans = Integer.MAX_VALUE;

    private void dfs(TreeNode root, int height) {
        if (root == null) return;
        if (height >= ans) return;
        if (root.left == null && root.right == null) ans = height;
        dfs(root.left, height + 1);
        dfs(root.right, height + 1);
    }

    /**
     * DFS+剪枝
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution2().minDepth(TreeUtil.buildTree(new Integer[]{
                3,
                9, 20,
                null, null, 15, 7
        }))); // 2
        System.out.println(new Solution2().minDepth(TreeUtil.buildTree(new Integer[]{
                1,
                2, 3,
                4, null, null, 5
        }))); // 3
    }
}
