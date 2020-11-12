package problem514;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        // 初始化字符的可能位置
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        // dp
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 0x3f3f3f); // 0x3f3f3f表示“无穷大”
        }
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(
                            dp[i][j],
                            dp[i-1][k] + Math.min(
                                    Math.abs(j - k),
                                    n - Math.abs(j - k)
                            ) + 1
                    );
                }
            }
        }
        return Arrays.stream(dp[m-1]).min().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().findRotateSteps("godding", "gd")); // 4
        System.out.println(new Solution2().findRotateSteps("caotmcaataijjxi", "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx")); // 4
    }
}
