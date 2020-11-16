package problem322;

import java.util.Arrays;
import java.util.HashMap;

public class Solution3 {
    /**
     * 动态规划
     * base case 金额 0：0,金额 小于0：-1
     * 状态：金额
     * 选择：使用某一硬币
     * dp: 凑出金额n的最小硬币数
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        // base case:
        dp[0] = 0;
        for (int coin : coins) {
            if (coin > amount) continue;
            dp[coin] = 1;
        }
        // 状态
        for (int i = 1; i <= amount; i++) {
            // 选择
            for (int coin : coins) {
                // 跳过不可能的情况
                if (coin > i) continue;
                if (dp[i - coin] == -1) continue;
                // 求最小值
                if (dp[i] == -1) {
                    dp[i] = dp[i - coin] + 1;
                } else {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().coinChange(new int[]{1, 2, 5}, 11)); // 3
    }
}
