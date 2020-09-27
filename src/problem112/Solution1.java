package problem112;

import common.TreeNode;
import common.TreeUtil;

public class Solution1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().hasPathSum(TreeUtil.buildTree(new Integer[]{
                5,
                4, 8,
                11, null, 13, 4,
                7, 2, null, null, null, null, null, 1
        }), 22)); // true
        System.out.println(new Solution1().hasPathSum(TreeUtil.buildTree(new Integer[]{}), 0)); // false
    }
}
