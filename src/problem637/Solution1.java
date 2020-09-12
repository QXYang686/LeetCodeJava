package problem637;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 {

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            double sum = 0;
            int levelCount = nodeQueue.size();
            for (int i = 0; i < levelCount; ++i) {
                TreeNode node = nodeQueue.poll();
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }
                sum += node.val;
            }
            result.add(sum / levelCount);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode20 = new TreeNode(20);
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        System.out.println(new Solution1().averageOfLevels(treeNode3)); // [3,14.5,11]
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