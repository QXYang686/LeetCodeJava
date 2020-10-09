package problem230;

import common.TreeNode;
import common.TreeUtil;

public class Solution1 {
    private int curIndex = 0;
    private int ans;

    private boolean dfs(TreeNode root,int k) {
        if (root == null) return false;
        if (dfs(root.left, k)) return true;
        if (++curIndex == k) {
            ans = root.val;
            return true;
        }
        if (dfs(root.right, k)) return true;
        return false;
    }

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().kthSmallest(TreeUtil.buildTree(new Integer[]{3,1,4,null,2}), 1)); // 1
        System.out.println(new Solution1().kthSmallest(TreeUtil.buildTree(new Integer[]{5,3,6,2,4,null,null,1}), 3)); // 3
    }
}
