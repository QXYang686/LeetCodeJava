package problem76;

public class Solution1 {
    public String minWindow(String s, String t) {
        String ans = null;
        int[] need = new int[128], window = new int[128];
        // 初始化need
        for (char c : t.toCharArray()) need[c]++;
        // 滑动窗口算法开始
        int left = 0, right = 0;
        while (right < s.length()) {
            // c是将移入窗口的字符
            char c = s.charAt(right);
            // 右滑窗口
            right++;
            // 进行窗口内数据的一系列更新
            window[c]++;

            // 判断左侧窗口是否要收缩
            char changedChar = 0;
            while (valid(need, window, changedChar)) {
                // 更新答案
                if (ans == null || ans.length() > right - left) {
                    ans = s.substring(left, right);
                }

                // d是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内的数据的一系列更新
                changedChar = d;
                window[d]--;
            }
        }
        return ans == null ? "" : ans;
    }

    private boolean valid(int[] need, int[] window, char changedChar) {
        if (0 != changedChar) {
            return window[changedChar] >= need[changedChar];
        }
        else {
            for (int i = 0; i < 128; i++) {
                if (need[i] > window[i]) return false;
            }
        }
        return true;
    }
}
