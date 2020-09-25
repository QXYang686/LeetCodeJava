package problem106;

import common.TreeNode;
import common.TreeUtil;

import java.util.Arrays;

public class Solution1 {
    /**
     * 使用迭代寻找root位置,递归时拷贝子树数组
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int rootIndex = 0;
        while (inorder[rootIndex] != root.val) ++rootIndex;
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inRight = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, inLeft.length);
        int[] postRight = Arrays.copyOfRange(postorder, postLeft.length, postorder.length - 1);
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TreeUtil.buildArray(new Solution1().buildTree(
                new int[]{9, 3, 15, 20, 7},
                new int[]{9, 15, 7, 20, 3}
        )))); // [3,9,20,null,null,15,7]
    }
}
