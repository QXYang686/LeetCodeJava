package problem912;

import java.util.Arrays;
import java.util.Random;

public class Solution2 {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        /// 快速排序：
        /// 基于分治法思想，通过 O(n) 时间将数组粗排为值较大的、值较小的两个部分，
        /// 值较小的部分所有值都不会大于值较大的部分的任一值，因此两个部分间不需要交换
        /// 只要两个部分都分别排序完成，整个数组就排序完成
        /// 快速排序是非稳定的，时间复杂度平均 O(nlogn)，最坏 O(n^2)，空间复杂度 O(logn)，属于交换排序
        quickSort(nums, 0, nums.length);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (r - l < 2) {
            return;
        }
        /// 确定一个中枢，比中枢小的都粗排在左边，比中枢大的都粗排在右边
        /// 中枢的选择关系到划分是否平均，从而影响最终时间，需要根据数据分布进行选择
        int i = l, j = r - 1;
        /// 随机选择作为一种应对方案可以处理已排序数据等恶劣情况
        {
            int at = new Random().nextInt(l, r);
            int temp = nums[at];
            nums[at] = nums[j];
            nums[j] = temp;
        }
        int pivot = nums[j];
        while (i < j) {
            while (i < j && nums[i] <= pivot) i++; // 交换结束或左侧不满足条件了
            if (i < j) nums[j--] = nums[i]; // 交换未结束就把不满足条件的换到右边
            while (i < j && nums[j] >= pivot) j--; // 交换结束或右侧不满足条件了
            if (i < j) nums[i++] = nums[j]; // 交换未结束就把不满足条件的放到左边
        }
        // 划分完成，i == j 一定成立，且该位置应用来存放中轴值
        nums[i] = pivot;
        /// 如何保证问题规模一定减少呢？
        /// 由于中间位置一定等于中轴，可将中间位置排除在子问题之外
        /// 也可以针对全部为相等值的情况进行更大范围的排除
        while (i > l && nums[i] == nums[i - 1]) i--;
        while (j < r - 1 && nums[j] == nums[j + 1]) j++;
        quickSort(nums, l, i);
        quickSort(nums, j + 1, r);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new Solution2().sortArray(new int[]{5, 2, 3, 1}), new int[]{1, 2, 3, 5}));
        System.out.println(Arrays.equals(new Solution2().sortArray(new int[]{5, 1, 1, 2, 0, 0}), new int[]{0, 0, 1, 1, 2, 5}));
        System.out.println(Arrays.toString(new Solution2().sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}
