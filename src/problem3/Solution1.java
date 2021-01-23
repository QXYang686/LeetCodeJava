package problem3;

public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] window = new int[128];
        // 开始滑动窗口算法
        int left = 0, right = 0;
        while (right < s.length()) {
            // 放大窗口
            char c = s.charAt(right++);
            window[c]++;

            // 满足条件
            if (window[c] <= 1) {
                ans = Math.max(ans, right - left);
            }

            while (window[c] > 1) {
                // 缩小窗口
                char d = s.charAt(left++);
                window[d]--;
                // 由于缩小后的值长度必定小于或等于放大时得到的结果，可以跳过检测
            }
        }
        return ans;
    }
}
