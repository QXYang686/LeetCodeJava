package problem124;

import common.TreeNode;
import common.TreeUtil;

import java.util.ArrayList;
import java.util.Collections;

public class Solution1 {
    private long ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxUpPathSum(root);
        return (int)ans;
    }

    /**
     * 单向最大长度
     * @param root
     * @return long型结果（int型溢出）
     */
    private long maxUpPathSum(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        long leftMaxUpPathSum = maxUpPathSum(root.left);
        long rightMaxUpPathSum = maxUpPathSum(root.right);
        // 单向最大值
        long result = Math.max(root.val, Math.max(root.val + leftMaxUpPathSum, root.val + rightMaxUpPathSum));
        // 最终结果需要包含两向
        ans = Math.max(ans, Math.max(result, root.val + leftMaxUpPathSum + rightMaxUpPathSum));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().maxPathSum(TreeUtil.buildTree(new Integer[]{1,2,3}))); // 6
        System.out.println(new Solution1().maxPathSum(TreeUtil.buildTree(new Integer[]{-10,9,20,null,null,15,7}))); // 42
        System.out.println(new Solution1().maxPathSum(TreeUtil.buildTree(new Integer[]{-3}))); // -3
    }
}
