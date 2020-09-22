package problem968;

import common.TreeNode;
import common.TreeUtil;

public class Solution2 {
    public int minCameraCover(TreeNode root) {
        int[] array = dfs(root);
        return array[1];
    }

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        int[] leftArray = dfs(root.left);
        int[] rightArray = dfs(root.right);
        int[] array = new int[3];
        array[0] = leftArray[2] + rightArray[2] + 1;
        array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], leftArray[1] + rightArray[0]));
        array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
        return array;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().minCameraCover(TreeUtil.buildTree(new Integer[]{1,2,null,4,5}))); // 1
        System.out.println(new Solution2().minCameraCover(TreeUtil.buildTree(new Integer[]{
                1,
                2,null,
                4,null,null,null,
                8,null,null,null,null,null,null,null,
                16
        }))); // 2
    }
}
