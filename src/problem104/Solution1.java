package problem104;

import common.TreeNode;
import common.TreeUtil;

public class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().maxDepth(TreeUtil.buildTree(new Integer[]{3,9,20,null,null,15,7}))); // 3
    }
}
