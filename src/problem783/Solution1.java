package problem783;

import common.TreeNode;
import common.TreeUtil;

public class Solution1 {
    private int lastVal = -100_000;
    private int minDist = 100_000;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null) {
            minDiffInBST(root.left);
        }
        minDist = Math.min(minDist, root.val - lastVal);
        lastVal = root.val;
        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return minDist;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().minDiffInBST(TreeUtil.buildTree(new Integer[]{4, 2, 6, 1, 3})));
    }
}
