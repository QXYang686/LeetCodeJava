package problem912;

import java.util.Arrays;

public class Solution5 {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        /// 直接插入排序：
        /// 将数组分为两部分：有序数组，无序数组
        /// 从无序数组中取一个值，在有序数组中找一个合适的位置插入
        /// 使得有数数组部分扩大，无序数组部分缩小
        /// 每次扩大后，有序部分可能不止扩大 1 位，因此在整体有序的情况下，可减少大量操作
        /// 直接插入排序是稳定的，最优时间复杂度为 O(n)，最坏时间复杂度为 O(n^2)，属于插入排序
        int r = 1;
        while (r < nums.length) {
            // 尽可能扩大有序数组范围，结束后 r 定位在无序数组开头
            while (r < nums.length && nums[r - 1] <= nums[r]) r++;
            if (r == nums.length) break;
            // 从无序数组开头开始，将有序数组中的元素逐个后移，定位至目标位置放置选中值
            int pos = r, temp = nums[r];
            while (pos - 1 >= 0 && nums[pos - 1] > temp) {
                nums[pos] = nums[pos - 1];
                pos -= 1;
            }
            nums[pos] = temp;
            // 通过交换，有序数组直接扩张 1 个
            r++;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new Solution5().sortArray(new int[]{5, 2, 3, 1}), new int[]{1, 2, 3, 5}));
        System.out.println(Arrays.equals(new Solution5().sortArray(new int[]{5, 1, 1, 2, 0, 0}), new int[]{0, 0, 1, 1, 2, 5}));
        System.out.println(Arrays.toString(new Solution5().sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}
