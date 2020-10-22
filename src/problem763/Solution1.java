package problem763;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int['z' + 1];
        Arrays.fill(lastIndex, -1);
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            lastIndex[ch] = i;
        }
        int from = 0, last = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            last = Math.max(last, lastIndex[ch]);
            if (last == i) {
                ans.add(last - from + 1);
                from = last = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().partitionLabels("ababcbacadefegdehijhklij")); // [9, 7, 8]
    }
}
