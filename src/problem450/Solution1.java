package problem450;

import common.TreeNode;
import common.TreeUtil;

import java.util.Arrays;

public class Solution1 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        // 找到节点
        if (key == root.val) {
            // 左节点为空，右节点上移即可
            if (root.left == null) return root.right;
            // 右节点为空,左节点上移即可
            if (root.right == null) return root.left;
            // 左右节点均不为空,左右子树合并后上移
            return merge(root.left, root.right);
        }
        // 大于当前节点,在右子树删除
        else if (key > root.val) root.right = deleteNode(root.right, key);
        // 小于当前节点，在左子树删除
        else root.left = deleteNode(root.left, key);
        return root;
    }

    private TreeNode merge(TreeNode left, TreeNode right) {
        if (left == null) return right;
        if (right == null) return left;
        right.left = merge(left, right.left);
        return right;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TreeUtil.buildArray(new Solution1().deleteNode(TreeUtil.buildTree(new Integer[]{
                5, 3, 6, 2, 4, null, 7
        }), 3)))); // [5, 4, 6, 2, null, null, 7
    }
}
