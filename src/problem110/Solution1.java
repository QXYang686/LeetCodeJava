package problem110;

import common.TreeNode;
import common.TreeUtil;

import java.util.HashMap;

public class Solution1 {
    private HashMap<TreeNode, Integer> heights = new HashMap<>();

    private int height(TreeNode root) {
        if (root == null) return 0;
        if (!heights.containsKey(root)) {
            System.out.println(root.val);
            heights.put(root, Math.max(height(root.left), height(root.right)) + 1);
        }
        return heights.get(root);
    }

    /**
     * 自顶向下
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().isBalanced(TreeUtil.buildTree(new Integer[]{
                3,
                9,20,
                null,null,15,7
        }))); // true
        System.out.println(new Solution1().isBalanced(TreeUtil.buildTree(new Integer[]{
                1,
                2,2,
                3,3,null,null,
                4,4
        }))); // false
    }
}
