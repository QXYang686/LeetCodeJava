package problem912;

import java.util.Arrays;

public class Solution1 {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        /// 冒泡排序：
        /// 从低到高检查相邻元素是否逆序，并将逆序的值进行交换
        /// 第一轮检查后，最大值一定出现在最后的位置
        /// 此时下一轮排序就可以排除最后一位，问题缩小
        /// 这样多轮检查后可使得整体有序
        /// 冒泡排序是稳定的，时间复杂度固定为 O(n^2)，空间复杂度为 O(1)，属于交换排序
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new Solution1().sortArray(new int[]{5, 2, 3, 1}), new int[]{1, 2, 3, 5}));
        System.out.println(Arrays.equals(new Solution1().sortArray(new int[]{5, 1, 1, 2, 0, 0}), new int[]{0, 0, 1, 1, 2, 5}));
    }
}
