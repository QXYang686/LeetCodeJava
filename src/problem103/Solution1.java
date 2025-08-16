package problem103;

import common.TreeNode;
import common.TreeUtil;

import java.util.*;

public class Solution1 {
    // 双栈做法 -> 将双栈背对背贴合即为双端队列做法
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        if (root != null) stack.push(root);
        boolean leftFirst = true;
        while (!stack.isEmpty()) {
            ans.add(new ArrayList<>());
            ArrayDeque<TreeNode> levelStack = new ArrayDeque<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                ans.getLast().add(node.val);
                if (leftFirst) {
                    if (node.left != null) levelStack.push(node.left);
                    if (node.right != null) levelStack.push(node.right);
                } else {
                    if (node.right != null) levelStack.push(node.right);
                    if (node.left != null) levelStack.push(node.left);
                }
            }
            stack = levelStack;
            leftFirst = !leftFirst;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().zigzagLevelOrder(TreeUtil.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}
