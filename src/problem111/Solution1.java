package problem111;

import common.TreeNode;
import common.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    /**
     * bfs
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int minHeight = 0;
        while (!nodeQueue.isEmpty()) {
            int levelCount = nodeQueue.size();
            ++minHeight;
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = nodeQueue.poll();
                if (node.left != null) nodeQueue.offer(node.left);
                if (node.right != null) nodeQueue.offer(node.right);
                if (node.left == null && node.right == null) return minHeight;
            }
        }
        return minHeight;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution1().minDepth(TreeUtil.buildTree(new Integer[]{
//                3,
//                9, 20,
//                null, null, 15, 7
//        }))); // 2
        System.out.println(new Solution1().minDepth(TreeUtil.buildTree(new Integer[]{
                1,
                2, 3,
                4, null, null, 5
        }))); // 3
    }
}
