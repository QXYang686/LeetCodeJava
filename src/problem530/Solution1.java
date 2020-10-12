package problem530;

import common.TreeNode;
import common.TreeUtil;

public class Solution1 {
    private int ans = Integer.MAX_VALUE;
    private int lastValue = -1;

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        // 迭代过程中计算差值
        if (lastValue != -1) ans = Math.min(root.val - lastValue, ans);
        lastValue = root.val;
        dfs(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().getMinimumDifference(TreeUtil.buildTree(new Integer[]{ // 1
                1,null,3,null,null,2
        })));
    }
}
