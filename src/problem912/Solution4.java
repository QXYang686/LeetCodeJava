package problem912;

import java.util.Arrays;

public class Solution4 {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        /// 堆排序：
        /// 将未排序数据建立为最大堆
        /// 每次从堆顶取出最大值，放置到最后
        /// 由于堆结构是紧凑的，存放堆的部分一直在数组头部连续存放
        /// 全部数据出堆后数组有序
        /// 简单选择排序是非稳定的，时间复杂度固定为 O(nlogn)，空间复杂度为 O(1)，属于选择排序
        /// 其中，建堆时间复杂度为 O(n)，出堆时间复杂度为 O(logn)
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            // 堆顶出堆
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            // 保持堆性质
            heapify(nums, i, 0);
        }
        return nums;
    }

    private void buildMaxHeap(int[] nums) {
        /// 从最后一个非叶节点开始保证每个子树满足堆性质
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }
    }

    private void heapify(int[] nums, int n, int i) {
        int t = i, l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && nums[l] > nums[t]) t = l;
        if (r < n && nums[r] > nums[t]) t = r;
        if (t != i) {
            /// 子树根节点不满足堆性质，需要下沉到子树中，并将子树中的真正堆顶放到根节点上
            int temp = nums[i];
            nums[i] = nums[t];
            nums[t] = temp;
            /// 由于子树做过交换，其根节点可能不再满足堆性质，递归执行下沉过程
            heapify(nums, n, t);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new Solution4().sortArray(new int[]{5, 2, 3, 1}), new int[]{1, 2, 3, 5}));
        System.out.println(Arrays.equals(new Solution4().sortArray(new int[]{5, 1, 1, 2, 0, 0}), new int[]{0, 0, 1, 1, 2, 5}));
        System.out.println(Arrays.toString(new Solution4().sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}
