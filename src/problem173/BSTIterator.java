package problem173;

import common.TreeNode;
import common.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTIterator {
    private ArrayList<TreeNode> nodes = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        TreeNode rootNode = new TreeNode(root.val, root.left, root.right);
        nodes.add(rootNode);
    }

    /** @return the next smallest number */
    public int next() {
        while (true) {
            // 取节点进行处理
            TreeNode node = nodes.remove(nodes.size() - 1);
            // 节点无子女，退出即可
            if (node.left == null && node.right == null) return node.val;
            // 添加右节点
            if (node.right != null) nodes.add(node.right);
            // 添加节点
            nodes.add(new TreeNode(node.val, null, null));
            // 添加左节点
            if (node.left != null) nodes.add(node.left);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtil.buildTree(new Integer[]{7, 3, 15, null, null, 9, 20});
        BSTIterator iterator = new BSTIterator(tree);
        System.out.println(iterator.next()); // 3
        System.out.println(iterator.next()); // 7
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next()); // 9
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next()); // 15
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next()); // 20
        System.out.println(iterator.hasNext()); // false


    }
}
