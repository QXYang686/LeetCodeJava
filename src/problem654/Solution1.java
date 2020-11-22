package problem654;

import common.TreeNode;

public class Solution1 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int begin = 0, end = nums.length;
        return buildTree(nums, begin, end);
    }

    TreeNode buildTree(int[] nums, int begin, int end) {
        if (begin >= end) return null;
        int middle = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] > nums[middle]) middle = i;
        }
        TreeNode node = new TreeNode(nums[middle]);
        node.left = buildTree(nums, begin, middle);
        node.right = buildTree(nums, middle + 1, end);
        return node;
    }
}
