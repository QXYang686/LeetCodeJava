package problem912;

import java.util.Arrays;

public class Solution9 {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        /// 基数排序：
        /// 基数排序将值切分为不同的位，并利用值的大小关系可以通过每个位的比较来建立的特性来排序
        /// 由于每个可能的位都需要进行一轮比较，因此需要根据位数迭代若干轮
        /// 每一轮内部，按照该位的取值进行分桶
        /// 随后按桶的顺序重构数组
        /// 由于重构的过程是稳定的，在当前位取值相同的值，其内部顺序是依靠前面的轮次形成的顺序来确定的
        /// 这样就形成了对每一位依次比较，相同的比较下一位，不同则比较当前位的字典序比较方案
        /// 基数排序是稳定的，时间复杂度为 O(nk)，空间复杂度为 O(n+k)，属于外部排序

        // 处理为非负数的范围
        long[] arr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = nums[i] + 50_000;
        for (int i = 0; i < 32; i++) {
            // 按二进制基数分桶，最多 32 轮
            long[] zeros = new long[nums.length], ones = new long[nums.length];
            long mask = 1 << i;
            int z = 0, o = 0;
            for (long num : arr) {
                if ((mask & num) == 0) zeros[z++] = num;
                else if ((mask & num) != 0) ones[o++] = num;
            }
            // 桶合并
            long[] newArr = new long[nums.length];
            int pos = 0;
            for (int j = 0; j < z; j++) newArr[pos++] = zeros[j];
            for (int j = 0; j < o; j++) newArr[pos++] = ones[j];
            // 替换到下一轮继续使用
            arr = newArr;
        }
        // 重建数组
        for (int i = 0; i < nums.length; i++) nums[i] = (int) (arr[i] - 50_000);
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new Solution9().sortArray(new int[]{5, 2, 3, 1}), new int[]{1, 2, 3, 5}));
        System.out.println(Arrays.equals(new Solution9().sortArray(new int[]{5, 1, 1, 2, 0, 0}), new int[]{0, 0, 1, 1, 2, 5}));
        System.out.println(Arrays.toString(new Solution9().sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}
