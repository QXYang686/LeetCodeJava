package problem144;

import common.TreeNode;
import common.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    private List<Integer> ans = new ArrayList<>();

    /**
     * 迭代法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return ans;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().preorderTraversal(TreeUtil.buildTree(new Integer[]{
                1,
                null,2,
                null,null,3
        }))); // [1,2,3]
    }
}
