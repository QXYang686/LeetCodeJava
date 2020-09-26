package problem101;

import common.TreeNode;
import common.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    private Queue<TreeNode> queue1 = new LinkedList<>();
    private Queue<TreeNode> queue2 = new LinkedList<>();

    /**
     * 迭代方法
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        queue1.offer(root);
        queue2.offer(root);
        while (!queue1.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) return false;
            if ((node1.left == null) ^ (node2.right == null)) return false;
            if ((node1.right == null) ^ (node2.left == null)) return false;
            if (node1.left != null) {
                queue1.offer(node1.left);
                queue2.offer(node2.right);
            }
            if (node1.right != null) {
                queue1.offer(node1.right);
                queue2.offer(node2.left);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isSymmetric(TreeUtil.buildTree(new Integer[]{1,2,2,3,4,4,3}))); // true
        System.out.println(new Solution2().isSymmetric(TreeUtil.buildTree(new Integer[]{1,2,2,null,3,null,3}))); // false
    }
}
