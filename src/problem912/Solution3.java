package problem912;

import java.util.Arrays;
import java.util.Random;

public class Solution3 {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        /// 简单选择排序：
        /// 从未排序数据中找出最大值，将最大值放到最后
        /// 此时下一轮排序就可以排除最后一位，问题缩小
        /// 这样多轮检查后可使得整体有序
        /// 简单选择排序是非稳定的，时间复杂度固定为 O(n^2)，空间复杂度为 O(1)，属于选择排序
        for (int i = nums.length - 1; i >= 0; i--) {
            int maxAt = i, max = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                if (nums[j] > max) {
                    maxAt = j;
                    max = nums[j];
                }
            }
            int temp = nums[i];
            nums[i] = nums[maxAt];
            nums[maxAt] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new Solution3().sortArray(new int[]{5, 2, 3, 1}), new int[]{1, 2, 3, 5}));
        System.out.println(Arrays.equals(new Solution3().sortArray(new int[]{5, 1, 1, 2, 0, 0}), new int[]{0, 0, 1, 1, 2, 5}));
        System.out.println(Arrays.toString(new Solution3().sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}
