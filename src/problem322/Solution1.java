package problem322;

public class Solution1 {
    /**
     * 暴力法，递归，超时
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = -1;
        for (int coin : coins) {
            int ans = coinChange(coins, amount - coin);
            if (ans == -1) continue;
            if (res == -1) res = ans + 1;
            else res = Math.min(res, ans + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().coinChange(new int[]{1, 2, 5}, 11));
    }
}
