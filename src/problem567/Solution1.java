package problem567;

public class Solution1 {
    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[128], window = new int[128];
        // 初始化
        for (char c : s1.toCharArray()) {
            need[c]++;
        }
        // 开始滑动窗口算法
        int left = 0, right = 0;
        while (right < s2.length()) {
            // 放大窗口
            char c = s2.charAt(right++);
            window[c]++;
            // 达成条件直接返回,通过当前字符短路大量判断工作
            if (window[c] == need[c] && valid(need, window)) {
                return true;
            }

            // 收缩窗口
            while (left < right && window[c] > need[c]) {
                char d = s2.charAt(left++);
                window[d]--;
                // 达成条件直接返回,通过当前字符短路大量判断工作
                if (window[d] == need[d] && valid(need, window)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean valid(int[] need, int[] window) {
        int i = 0;
        while (i < 128 && need[i] == window[i]) i++;
        return i == 128;
    }
}
