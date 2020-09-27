package problem102;

import common.TreeNode;
import common.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        if (root == null) return ans;
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int levelCount = nodeQueue.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode curNode = nodeQueue.poll();
                level.addLast(curNode.val);
                if (curNode.left != null) nodeQueue.offer(curNode.left);
                if (curNode.right != null) nodeQueue.offer(curNode.right);
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().levelOrder(TreeUtil.buildTree(new Integer[]{3,9,20,null,null,15,7}))); // [[3], [9, 20], [15, 7]]
    }
}
