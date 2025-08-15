package problem912;

import java.util.Arrays;

public class Solution8 {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        /// 计数排序：
        /// 计数排序是针对整数的排序方法
        /// 由于整数的取值范围有限，且所有可能取值有固定的大小关系
        /// 计数排序为每个可能取值按顺序安排一个位置
        /// 随后通过一次遍历，快速将每个取值的次数记录到该位置上
        /// 随后根据统计次数依次重建，即可将原始数组重新构造为一个有序的数组
        /// 这种排序的时间复杂度除了与数组规模相关，还与数组中值的取值范围相关
        /// 这种思路实际上启发我们在解决问题时去注意输入输出的取值范围
        /// 计数排序是稳定的，时间复杂度为 O(n+k)，空间复杂度为 O(k)，属于外部排序
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] mem = new int[max - min + 1];
        for (int num : nums) {
            mem[num - min]++;
        }
        int[] ans = new int[nums.length];
        int pos = 0;
        for (int i = 0; i < mem.length; i++) {
            while (mem[i]-- > 0) ans[pos++] = i + min;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new Solution8().sortArray(new int[]{5, 2, 3, 1}), new int[]{1, 2, 3, 5}));
        System.out.println(Arrays.equals(new Solution8().sortArray(new int[]{5, 1, 1, 2, 0, 0}), new int[]{0, 0, 1, 1, 2, 5}));
        System.out.println(Arrays.toString(new Solution8().sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}
