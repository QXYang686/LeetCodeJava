package problem1339;

import common.TreeNode;
import common.TreeUtil;

import java.util.HashMap;

public class Solution2 {
//    private HashMap<TreeNode, Long> sum = new HashMap<>();
    private long maxProduct = 0;

    /**
     * 通过哈希表存储节点总和没有存在的必要
     * 即便存储了这些节点，仍然需要O(N)的复杂度来求和
     * @param root
     * @return
     */
    public int maxProduct(TreeNode root) {
        long totalSum = sum(root);
//        sum.put(null, 0L);
        dfs(root, totalSum);
        return (int)(maxProduct % (1_000_000_000 + 7));
    }

    private long dfs(TreeNode node, long total) {
        if (node == null) return 0;
        long left = dfs(node.left, total);
        long right = dfs(node.right, total);
        long sum = left + right + node.val;
        maxProduct = Math.max(maxProduct, (total - sum) * sum);
        return sum;
    }

    private long sum(TreeNode node) {
        if (node == null) return 0;
        long leftSum = sum(node.left);
        long rightSum = sum(node.right);
//        sum.put(node, leftSum + rightSum + node.val);
        return leftSum + rightSum + node.val;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(new Solution2().maxProduct(root));
    }
}
