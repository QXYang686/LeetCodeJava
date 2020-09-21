package common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
    public static TreeNode buildTree(Integer[] values) {
        if (values.length == 0) return null;
        TreeNode[] nodes = new TreeNode[values.length];
        for (int i = 0; i < values.length; ++i) {
            if (values[i] == null) continue;
            nodes[i] = new TreeNode(values[i]);
            // 维护节点关系
            if (i != 0) {
                if (i % 2 == 0) nodes[(i - 1) / 2].right = nodes[i];
                else nodes[(i - 1) / 2].left = nodes[i];
            }
        }
        return nodes[0];
    }

    public static Integer[] buildArray(TreeNode root) {
        if (root == null) return new Integer[0];
        Queue<TreeNode> validQueue = new LinkedList<>();
        Queue<TreeNode> structQueue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();
        validQueue.offer(root);
        structQueue.offer(root);
        while (!validQueue.isEmpty()) {
            TreeNode validNode = validQueue.poll();
            // 结构性节点输出null
            while (structQueue.poll() != validNode) {
                result.offer(null);
                structQueue.offer(null);
                structQueue.offer(null);
            }
            // 处理并入队
            result.offer(validNode.val);
            if (validNode.left != null) validQueue.offer(validNode.left);
            if (validNode.right != null) validQueue.offer(validNode.right);
            structQueue.offer(validNode.left);
            structQueue.offer(validNode.right);
        }
        return result.toArray(new Integer[0]);
    }
}
