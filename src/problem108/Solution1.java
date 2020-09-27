package problem108;

import common.TreeNode;
import common.TreeUtil;

import java.util.Arrays;

public class Solution1 {
    private TreeNode dfs(int[] nums, int from, int to) {
        if (from >= to) return null;
        int rootIndex = (from + to) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = dfs(nums, from, rootIndex);
        root.right = dfs(nums, rootIndex + 1, to);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TreeUtil.buildArray(
                new Solution1().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9})
        ))); // [0,-3,9,-10,null,5]
    }
}
