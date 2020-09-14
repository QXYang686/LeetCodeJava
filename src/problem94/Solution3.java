package problem94;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution3 {
    /**
     * 使用栈模拟递归的中序遍历,改变树结构
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        if (root == null) return path;
        ArrayDeque<TreeNode> traversalStack = new ArrayDeque<>();
        traversalStack.push(root);
        while (!traversalStack.isEmpty()) {
            TreeNode cur = traversalStack.poll();
            // 无子女,可以输出
            if (cur.left == null && cur.right == null) {
                path.add(cur.val);
            }
            // 有子女,入栈并清除子女
            else {
                if (cur.right != null) traversalStack.push(cur.right);
                traversalStack.push(cur);
                if (cur.left != null) traversalStack.push(cur.left);
                cur.left = cur.right = null;
            }
        }
        return path;
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = treeNode3;
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = treeNode2;
        System.out.println(new Solution3().inorderTraversal(treeNode1)); // [1,3,2]
    }
}
