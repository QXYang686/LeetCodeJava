package problem617;

import common.TreeNode;
import common.TreeUtil;

import java.util.Arrays;

public class Solution1 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TreeUtil.buildArray(new Solution1().mergeTrees(
                TreeUtil.buildTree(new Integer[]{
                        1,
                        3, 2,
                        5
                }),
                TreeUtil.buildTree(new Integer[]{
                        2,
                        1, 3,
                        null, 4, null, 7
                })
        )))); // [3,4,5,5,4,null,7]
    }
}
