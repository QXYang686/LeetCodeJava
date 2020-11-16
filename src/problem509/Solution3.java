package problem509;

import java.util.HashMap;

class Solution3 {
    /**
     * 动态规划，自底向上
     * @param N
     * @return
     */
    public int fib(int N) {
        int[] dp = new int[Math.max(2, N + 1)];
        // base case
        dp[0] = 0; dp[1] = 1;
        // 遍历状态1的所有取值
        for (int i = 2; i < N + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().fib(2)); // 1
        System.out.println(new Solution3().fib(1)); // 1
    }
}
