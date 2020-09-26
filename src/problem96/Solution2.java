package problem96;

import java.util.Arrays;
import java.util.Collections;

public class Solution2 {
    private int[][] memo;

    /**
     * 递归，记忆化搜索（似乎不管用）
     * @param n
     * @return
     */
    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        if (n == 0) return 0;
        return dfs(1, n + 1);
    }

    private int dfs(int from, int to) {
        // 记忆
        if (memo[from - 1][to - 1] != -1) return memo[from - 1][to - 1];
        // null
        if (from >= to) return 1;
        int types = 0;
        for (int i = from; i < to; i++) {
            int leftCount = dfs(from, i);
            int rightCount = dfs(i + 1, to);
            types += leftCount * rightCount;
        }
        return types;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().numTrees(3)); // 5
    }
}
