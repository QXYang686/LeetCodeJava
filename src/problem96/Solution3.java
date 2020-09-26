package problem96;

import java.util.Arrays;

public class Solution3 {
    private int[] memo;

    /**
     * 从上一方案来说，重复性主要来自[from,from+size)与[from+x,from+x+size),实际上是一样的
     * @param n
     * @return
     */
    public int numTrees(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return dfs(n);
    }

    private int dfs(int n) {
        if (memo[n] != -1) return memo[n];
        int typeCount = 0;
        for (int i = 0; i < n; ++i) {
            int leftCount = dfs(i);
            int rightCount = dfs(n - i - 1);
            typeCount += leftCount * rightCount;
        }
        return memo[n] = typeCount;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().numTrees(3)); // 5
    }
}
