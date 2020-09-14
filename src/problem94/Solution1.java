package problem94;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    private List<Integer> path = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return path;
        if (root.left != null) inorderTraversal(root.left);
        path.add(root.val);
        if (root.right != null) inorderTraversal(root.right);
        return path;
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = treeNode3;
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = treeNode2;
        System.out.println(new Solution1().inorderTraversal(treeNode1)); // [1,3,2]
    }
}


/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}