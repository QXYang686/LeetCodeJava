package problem1339;

import common.TreeNode;
import common.TreeUtil;

import java.util.HashMap;

public class Solution1 {
    private HashMap<TreeNode, Long> sum = new HashMap<>();
    private long maxProduct = 0;

    public int maxProduct(TreeNode root) {
        long totalSum = sum(root);
        sum.put(null, 0L);
        dfs(root, totalSum);
        return (int)(maxProduct % (1_000_000_000 + 7));
    }

    private void dfs(TreeNode node, long total) {
        if (node == null) return;
        long tempMax = Math.max(
                (total - sum.get(node.left)) * sum.get(node.left),
                (total - sum.get(node.right)) * sum.get(node.right)
        );
        maxProduct = Math.max(maxProduct, tempMax);
        dfs(node.left, total);
        dfs(node.right, total);
    }

    private long sum(TreeNode node) {
        if (node == null) return 0;
        long leftSum = sum(node.left);
        long rightSum = sum(node.right);
        sum.put(node, leftSum + rightSum + node.val);
        return leftSum + rightSum + node.val;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(new Solution1().maxProduct(root));
    }
}
