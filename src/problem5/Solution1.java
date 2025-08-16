package problem5;

import java.nio.charset.StandardCharsets;

public class Solution1 {
    // 针对具体问题的具体分析算法，从中间扩展，时间复杂度 O(n^2)
    public String longestPalindrome(String s) {
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        int[] best = new int[]{0, -1};
        for (int i = 0; i < bytes.length; i++) {
            int[] odd = palindrome(bytes, i, i);
            int[] even = palindrome(bytes, i, i + 1);
            if (odd[1] - odd[0] > best[1] - best[0]) best = odd;
            if (even[1] - even[0] > best[1] - best[0]) best = even;
        }
        return new String(bytes, best[0], best[1] - best[0] + 1);
    }

    private int[] palindrome(byte[] bytes, int l, int r) {
        // 不是回文串
        if (l > r || l < 0 || r >= bytes.length || bytes[l] != bytes[r]) return new int[]{0, -1};
        // 向两边扩展
        while (l >= 0 && r < bytes.length && bytes[l] == bytes[r]) {
            l--;
            r++;
        }
        return new int[]{l + 1, r - 1};
    }

    public static void main(String[] args) {
        System.out.println("bab".equals(new Solution1().longestPalindrome("babad")) || "aba".equals(new Solution1().longestPalindrome("aba")));
        System.out.println("bb".equals(new Solution1().longestPalindrome("cbbd")));
    }
}
