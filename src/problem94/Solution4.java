package problem94;

import common.TreeUtil;
import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution4 {
    /**
     * 递归改栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().inorderTraversal(TreeUtil.buildTree(
                new Integer[]{1, null, 2, null, null, 3}
        )));
    }
}
