package problem912;

import java.util.Arrays;

public class Solution7 {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        /// 归并排序：
        /// 以双路归并排序为例
        /// 首先保证两路内部均为有序的
        /// 这样最小值一定在两路之中的其中一路的开头
        /// 将最小值从中取出后，剩下的最小值仍然在两路之一的开头
        /// 这样迭代知道两路全部清空即完成两路归并
        /// 要保证两路内部有序，只需要递归调用即可将问题规模降到可以直接得出结论的程度
        /// 归并排序是稳定的，时间复杂度固定为 O(nlogn)，空间复杂度 O(logn)
        int[] left = Arrays.copyOfRange(nums, 0, nums.length / 2);
        int[] right = Arrays.copyOfRange(nums, nums.length / 2, nums.length);
        return mergeSort(left, right);
    }

    private int[] mergeSort(int[] left, int[] right) {
        // 保证两路有序
        if (left.length > 1) left = mergeSort(Arrays.copyOfRange(left, 0, left.length / 2), Arrays.copyOfRange(left, left.length / 2, left.length));
        if (right.length > 1) right = mergeSort(Arrays.copyOfRange(right, 0, right.length / 2), Arrays.copyOfRange(right, right.length / 2, right.length));
        // 两路合并
        int[] ans = new int[left.length + right.length];
        int l = 0, r = 0;
        for (int i = 0; i < ans.length; i++) {
            if (l == left.length) ans[i] = right[r++];
            else if (r == right.length) ans[i] = left[l++];
            else if (left[l] >= right[r]) ans[i] = right[r++];
            else if (left[l] < right[r]) ans[i] = left[l++];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new Solution7().sortArray(new int[]{5, 2, 3, 1}), new int[]{1, 2, 3, 5}));
        System.out.println(Arrays.equals(new Solution7().sortArray(new int[]{5, 1, 1, 2, 0, 0}), new int[]{0, 0, 1, 1, 2, 5}));
        System.out.println(Arrays.toString(new Solution7().sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}
