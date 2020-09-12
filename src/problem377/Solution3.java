package problem377;

import java.util.Arrays;
import java.util.HashMap;

public class Solution3 {
    // 动态规划
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; ++i) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().combinationSum4(new int[]{1,2,3}, 4)); // 7
        System.out.println(new Solution3().combinationSum4(new int[]{2,1,3}, 35)); // 超时
    }
}
