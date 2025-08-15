package problem912;

import java.util.Arrays;

public class Solutiona {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        /// 桶排序：
        /// 桶排序根据数据的范围，将数据映射到不同的桶中，不同的桶之间有大小关系
        /// 通过分桶的过程，实现了与快排中分区相似的初步排序的特征
        /// 每个桶内排序后将不同的桶进行拼接即可完成整体的排序
        /// 桶排序是稳定的，时间复杂度为O(n+k)，最差时间复杂度为 O(n^2)，空间复杂度为 O(n+k)，属于外部排序
        bucketSort(nums, -50_000, 50_000);
        return nums;
    }

    private int[] bucketSort(int[] nums, int min, int max) {
        // 无法分桶的情况直接返回
        boolean dividable = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                dividable = true;
                break;
            }
        }
        if (!dividable) return nums;
        // 这里先按取值范围固定分 N 个桶来处理
        int N = 4, bs = Math.max(1, (max - min) / N);
        // 分桶
        int[][] buckets = new int[N][nums.length];
        int[] bc = new int[N];
        for (int num : nums) {
            int bi = Math.min(N - 1, (num - min) / bs);
            buckets[bi][bc[bi]] = num;
            bc[bi]++;
        }
        // 桶内排序
        for (int i = 0; i < N; i++) {
            buckets[i] = bucketSort(Arrays.copyOfRange(buckets[i], 0, bc[i]), min + i * bs, min + bs + i * bs);
        }
        // 桶合并
        int pos = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < bc[i]; j++) {
                nums[pos++] = buckets[i][j];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new Solutiona().sortArray(new int[]{5, 2, 3, 1}), new int[]{1, 2, 3, 5}));
        System.out.println(Arrays.equals(new Solutiona().sortArray(new int[]{5, 1, 1, 2, 0, 0}), new int[]{0, 0, 1, 1, 2, 5}));
        System.out.println(Arrays.toString(new Solutiona().sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}
