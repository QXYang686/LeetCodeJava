package problem236;

import common.TreeNode;
import common.TreeUtil;

public class Solution2 {
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private int dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return 0;
        int l = dfs(node.left, p, q);
        int r = dfs(node.right, p, q);
        int m = (node == p || node == q) ? 1 : 0;
        if (l == 1 && r == 1) ans = node;
        if (m == 1 && (l == 1 || r == 1)) ans = node;
        return l + m + r;
    }


    public static void main(String[] args) {
        TreeNode case1 = TreeUtil.buildTree(new Integer[]{
                        3,5,1,6,2,0,8,null,null,7,4
                });
        System.out.println(new Solution2().lowestCommonAncestor(case1, case1.left, case1.right).val);
        TreeNode case2 = TreeUtil.buildTree(new Integer[]{
                        3,5,1,6,2,0,8,null,null,7,4
                });
        System.out.println(new Solution2().lowestCommonAncestor(case2, case2.left, case2.left.right.right).val);
    }
}
