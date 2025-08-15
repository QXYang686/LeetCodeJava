package problem912;

import java.util.Arrays;

public class Solution6 {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        /// 希尔排序：
        /// 首先将数组按照不同的求模余数分成若干份
        /// 对每一份进行直接选择排序
        /// 再用更小的模数合并为更少的份数
        /// 对每一份进行直接选择排序
        /// 直到仅剩一份进行直接选择排序
        /// 希尔排序是非稳定的，最优时间复杂度为 O(nlogn)，最坏时间复杂度为 O(n^2)，平均时间复杂度为 O(nlogn)，属于插入排序
        int step = nums.length / 2;
        while (step != 0) {
            for (int i = 0; i < step; i++) {
                // i + n * step 构成一小份，对这一小份进行插入排序
                int r = i + step;
                while (r < nums.length) {
                    while (r < nums.length && nums[r] > nums[r - step]) r += step;
                    if (r >= nums.length) break;
                    int pos = r, temp = nums[r];
                    while (pos - step >= 0 && nums[pos - step] > temp) {
                        nums[pos] = nums[pos - step];
                        pos -= step;
                    }
                    nums[pos] = temp;
                    r += step;
                }
                System.out.println();
                for (int j = i; j < nums.length; j += step) {
                    System.out.print(nums[j]);
                }
            }
            step /= 2;
        }
        return nums;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.equals(new Solution6().sortArray(new int[]{5, 2, 3, 1}), new int[]{1, 2, 3, 5}));
//        System.out.println(Arrays.equals(new Solution6().sortArray(new int[]{5, 1, 1, 2, 0, 0}), new int[]{0, 0, 1, 1, 2, 5}));
        System.out.println(Arrays.toString(new Solution6().sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}
