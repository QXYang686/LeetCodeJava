package problem438;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    /**
     * 滑动窗口算法
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] need = new int[128], window = new int[128];
        // 初始化目标
        for (char c : p.toCharArray()) {
            need[c]++;
        }
        // 开始滑动窗口算法
        int left = 0, right = 0;
        while (right < s.length()) {
            // 扩大窗口
            char c = s.charAt(right++);
            window[c]++;
            // 匹配成功
            if (window[c] == need[c] && valid(need, window)) {
                ans.add(left);
            }

            while (left < right && window[c] > need[c]) {
                // 缩小窗口
                char d = s.charAt(left++);
                window[d]--;
                // 匹配成功
                if (window[d] == need[d] && valid(need, window)) {
                    ans.add(left);
                }
            }
        }
        return ans;
    }

    private boolean valid(int[] need, int[] window) {
        int i = 0;
        while (i < 128 && need[i] == window[i]) {
            i++;
        }
        return 128 == i;
    }
}
