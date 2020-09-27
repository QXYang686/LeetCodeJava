package problem235;

import common.TreeNode;
import common.TreeUtil;

import java.util.LinkedList;

public class Solution1 {
    private LinkedList<TreeNode> pPath = null, qPath = null;

    private void dfs(TreeNode root, TreeNode p, TreeNode q, LinkedList<TreeNode> path) {
        if (root == null) return;
        path.addLast(root);
        if (root == p) pPath = new LinkedList<>(path);
        if (root == q) qPath = new LinkedList<>(path);
        if (pPath != null && qPath != null) return;
        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
        path.removeLast();
    }

    /**
     * 未利用二叉搜索树的性质，效率过低
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q, new LinkedList<>());
        TreeNode ans = null;
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (pPath.get(i) == qPath.get(i)) ans = pPath.get(i);
            else break;
        }
        return ans;
    }

    public static void main(String[] args) {
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node0 = new TreeNode(0);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node9 = new TreeNode(9);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(5);
//        node6.left = node2;
//        node6.right = node8;
//        node2.left = node0;
//        node2.right = node4;
//        node8.left = node7;
//        node8.right = node9;
//        node4.left = node3;
//        node4.right = node5;
//        System.out.println(new Solution1().lowestCommonAncestor(node6, node2, node8).val); // 6
        TreeNode root = TreeUtil.buildTree(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        System.out.println(new Solution1().lowestCommonAncestor(root, root.left, root.left.right));
    }
}
