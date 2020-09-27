package problem105;

import common.TreeNode;
import common.TreeUtil;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    /**
     * 迭代法
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TreeUtil.buildArray(
                new Solution2().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7})
        ))); // [3,9,20,null,null,15,7]
    }
}
