package problem5;

import java.nio.charset.StandardCharsets;

public class Solution2 {
    // palindrome(s[i:j]) = palindrome(s[i+1,j-1]) && s[i] == s[j]
    public String longestPalindrome(String s) {
        byte[] bytes = s.getBytes();
        boolean[][] dp = new boolean[bytes.length][bytes.length];
        // 单字符、空串标记为回文串
        for (int i = 0; i < bytes.length; i++) dp[i][i] = true;
        for (int i = 0; i + 1 < bytes.length; i++) dp[i + 1][i] = true;
        // i 降低，j 升高
        int from = 0, to = 0;
        for (int j = 1; j < bytes.length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = dp[i + 1][j - 1] && bytes[i] == bytes[j];
                if (dp[i][j] && j - i + 1 > to - from + 1) {
                    from = i;
                    to = j;
                }
            }
        }
        return new String(bytes, from, to - from + 1);
    }

    public static void main(String[] args) {
//        System.out.println("bab".equals(new Solution2().longestPalindrome("babad")) || "aba".equals(new Solution2().longestPalindrome("aba")));
        System.out.println("bb".equals(new Solution2().longestPalindrome("cbbd")));
    }
}
