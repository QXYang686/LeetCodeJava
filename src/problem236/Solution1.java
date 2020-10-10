package problem236;

import common.TreeNode;
import common.TreeUtil;

import java.util.LinkedList;

public class Solution1 {
    private LinkedList<TreeNode> pPath = new LinkedList<>();
    private LinkedList<TreeNode> qPath = new LinkedList<>();
    private boolean pFound = false, qFound = false;

    private void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;
        if (pFound && qFound) return;
        if (!pFound) pPath.addLast(root);
        if (!qFound) qPath.addLast(root);
        pFound |= root == p;
        qFound |= root == q;
        dfs(root.left, p, q);
        dfs(root.right, p, q);
        if (!pFound) pPath.removeLast();
        if (!qFound) qPath.removeLast();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        TreeNode ancestor = null;
        while (!pPath.isEmpty() && !qPath.isEmpty()) {
            TreeNode pNode = pPath.removeFirst();
            TreeNode qNode = qPath.removeFirst();
            if (pNode == qNode) ancestor = pNode;
            else return ancestor;
        }
        return ancestor;
    }


    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{
                        3,5,1,6,2,0,8,null,null,7,4
                });
        System.out.println(new Solution1().lowestCommonAncestor(root, root.left, root.left.right.right).val);
    }
}
