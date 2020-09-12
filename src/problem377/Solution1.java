package problem377;

import java.util.Arrays;

/**
 * 组合总和 Ⅳ
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 */
public class Solution1 {
    private int result = 0;

    // 超时
    public int combinationSum4(int[] nums, int target) {
        // 排序,尽快剪枝
        Arrays.sort(nums);
        dfs(nums, target);
        return result;
    }

    private void dfs(int[] nums, int target) {
        // nums中不含负数，可以剪枝
        if (target <= 0) {
            if (target == 0) {
                ++result;
            }
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > target) {
                break;
            }
            dfs(nums, target - nums[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().combinationSum4(new int[]{1,2,3}, 4)); // 7
        System.out.println(new Solution1().combinationSum4(new int[]{2,1,3}, 35)); // 超时
    }
}
