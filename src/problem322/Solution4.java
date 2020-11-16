package problem322;

import java.util.Arrays;

public class Solution4 {
    /**
     * 动态规划,优化写法
     * base case 金额 0：0,金额 小于0：-1
     * 状态：金额
     * 选择：使用某一硬币
     * dp: 凑出金额n的最小硬币数
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int infinity = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, infinity);
        // base case:
        dp[0] = 0;
        // 状态
        for (int i = 1; i <= amount; i++) {
            // 选择
            for (int coin : coins) {
                // 求最值
                if (i >= coin) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return (dp[amount] == infinity) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().coinChange(new int[]{1, 2, 5}, 11)); // 3
    }
}
