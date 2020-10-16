package problem543;

import common.TreeNode;
import common.TreeUtil;

public class Solution1 {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        depth(root);
        return ans;
    }

    private int depth(TreeNode root) {
        // 空节点结束递归
        if (root == null) return 0;
        // 左右递归
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        // 更新结果
        ans = Math.max(ans, leftDepth + rightDepth);
        // 返回当前层深度
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().diameterOfBinaryTree(TreeUtil.buildTree(new Integer[]{
                1, 2, 3, 4, 5
        }))); // 3
    }
}
