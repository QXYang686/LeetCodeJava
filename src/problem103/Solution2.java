package problem103;

import common.TreeNode;
import common.TreeUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    // 双向队列 = 双栈做法+两个栈背对背
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) deque.offerLast(root);
        boolean lastOut = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            ans.add(new ArrayList<>());
            for (int i = 0; i < size; i++) {
                if (lastOut) {
                    TreeNode node = deque.pollLast();
                    ans.getLast().add(node.val);
                    if (node.left != null) deque.offerFirst(node.left);
                    if (node.right != null) deque.offerFirst(node.right);
                } else {
                    TreeNode node = deque.pollFirst();
                    ans.getLast().add(node.val);
                    if (node.right != null) deque.offerLast(node.right);
                    if (node.left != null) deque.offerLast(node.left);
                }
            }
            lastOut = !lastOut;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().zigzagLevelOrder(TreeUtil.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}
