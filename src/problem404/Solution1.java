package problem404;

import common.TreeNode;
import common.TreeUtil;

public class Solution1 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        // 左节点为叶子节点时计入和中
        if (root.left != null && root.left.left == null && root.left.right == null) sum += root.left.val;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().sumOfLeftLeaves(TreeUtil.buildTree(new Integer[]{3,9,20,null,null,15,7}))); // 24
        System.out.println(new Solution1().sumOfLeftLeaves(TreeUtil.buildTree(new Integer[]{1,2,3,4,5}))); // 4
    }
}
