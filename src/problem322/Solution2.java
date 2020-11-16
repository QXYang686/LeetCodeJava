package problem322;

import java.util.HashMap;

public class Solution2 {
    private HashMap<Integer, Integer> memo = new HashMap<>();
    /**
     * 暴力法，递归 + 备忘录
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (!memo.containsKey(amount)) {
            int res = -1;
            for (int coin : coins) {
                int ans = coinChange(coins, amount - coin);
                if (ans == -1) continue;
                if (res == -1) res = ans + 1;
                else res = Math.min(res, ans + 1);
            }
            memo.put(amount, res);
        }
        return memo.get(amount);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().coinChange(new int[]{1, 2, 5}, 11));
    }
}
