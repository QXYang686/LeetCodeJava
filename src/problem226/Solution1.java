package problem226;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    /**
     * 层序
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }

    public static void main(String[] args) {

    }

}