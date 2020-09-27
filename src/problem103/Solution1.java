package problem103;

import common.TreeNode;
import common.TreeUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        nodes.offer(root);
        boolean directionFlag = true;
        while (!nodes.isEmpty()) {
            int levelCount = nodes.size();
            LinkedList<Integer> levelAns = new LinkedList<>();
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = nodes.poll();
                // 写入答案
                if (directionFlag) {
                    levelAns.addLast(node.val);
                } else {
                    levelAns.addFirst(node.val);
                }
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
            }
            ans.addLast(levelAns);
            directionFlag = !directionFlag;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().zigzagLevelOrder(TreeUtil.buildTree(new Integer[]{3,9,20,null,null,15,7})));
    }
}
