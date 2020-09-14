package problem94;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution2 {
    /**
     * 使用栈模拟递归的中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        if (root == null) return path;
        ArrayDeque<TreeNode> traversalStack = new ArrayDeque<>();
        HashSet<TreeNode> childInStack = new HashSet<>();
        traversalStack.push(root);
        while (!traversalStack.isEmpty()) {
            TreeNode cur = traversalStack.poll();
            // 子节点已入栈,可以输出
            if (childInStack.contains(cur)) {
                path.add(cur.val);
            }
            // 子节点未入栈,入栈并标记
            else {
                if (cur.right != null) traversalStack.push(cur.right);
                traversalStack.push(cur);
                if (cur.left != null) traversalStack.push(cur.left);
                childInStack.add(cur);
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
        System.out.println(new Solution2().inorderTraversal(treeNode1)); // [1,3,2]
    }
}
