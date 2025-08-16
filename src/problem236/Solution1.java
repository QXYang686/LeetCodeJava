package problem236;

import common.TreeNode;
import common.TreeUtil;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class Solution1 {
    private ArrayDeque<TreeNode> pPath, qPath;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> path = new ArrayDeque<>();
        dfs(root, p, q, path);
        TreeNode ans = null;
        while (!pPath.isEmpty() && !qPath.isEmpty()) {
            TreeNode pa = pPath.pollFirst(), qa = qPath.pollFirst();
            if (pa == qa) {
                ans = pa;
            }
        }
        return ans;
    }

    private void dfs(TreeNode node, TreeNode p, TreeNode q, ArrayDeque<TreeNode> path) {
        if (node == null) return;
        path.offerLast(node);
        if (node == p) pPath = path.clone();
        else if (node == q) qPath = path.clone();
        dfs(node.left, p, q, path);
        dfs(node.right, p, q, path);
        path.pollLast();
    }


    public static void main(String[] args) {
        TreeNode case1 = TreeUtil.buildTree(new Integer[]{
                        3,5,1,6,2,0,8,null,null,7,4
                });
        System.out.println(new Solution1().lowestCommonAncestor(case1, case1.left, case1.right).val);
        TreeNode case2 = TreeUtil.buildTree(new Integer[]{
                        3,5,1,6,2,0,8,null,null,7,4
                });
        System.out.println(new Solution1().lowestCommonAncestor(case2, case2.left, case2.left.right.right).val);
    }
}
