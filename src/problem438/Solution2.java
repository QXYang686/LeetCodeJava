package problem438;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution2 {
    /**
     * 滑动窗口算法，利用字符串个数优化匹配效率
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] need = new int[128], window = new int[128];
        int needCharTypes = 0, validCharTypes = 0;
        // 初始化目标
        HashSet<Character> charSet = new HashSet<>();
        for (char c : p.toCharArray()) {
            need[c]++;
            charSet.add(c);
        }
        needCharTypes = charSet.size();
        // 开始滑动窗口算法
        int left = 0, right = 0;
        while (right < s.length()) {
            // 扩大窗口
            char c = s.charAt(right++);
            window[c]++;
            if (window[c] == need[c]) {
                validCharTypes++;
            }
            // 匹配成功，给定的字符数量匹配且没有其他字符的干扰（字符串长度相等即没有其他字符）即匹配成功
            if (validCharTypes == needCharTypes && right - left == p.length()) {
                ans.add(left);
            }

            while (left < right && window[c] > need[c]) {
                // 缩小窗口
                char d = s.charAt(left++);
                window[d]--;
                // NOTE 因为window[d]的变化，判断条件不同了
                if (window[d] + 1 == need[d]) {
                    validCharTypes--;
                }
                // 匹配成功，给定的字符数量匹配且没有其他字符的干扰（字符串长度相等即没有其他字符）即匹配成功
                if (validCharTypes == needCharTypes && right - left == p.length()) {
                    ans.add(left);
                }
            }
        }
        return ans;
    }
}
