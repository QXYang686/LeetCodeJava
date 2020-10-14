package problem1002;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public List<String> commonChars(String[] A) {
        List<String> ans = new LinkedList<>();
        int[] preCount = null;
        for (int i = 0; i < A.length; i++) {
            int[] count = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                count[A[i].charAt(j) - 'a']++;
            }
            if (preCount == null) {
                preCount = count;
            }
            else {
                for (int j = 0; j < 26; j++) {
                    preCount[j] = Math.min(preCount[j], count[j]);
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < preCount[i]; j++) {
                ans.add("" + (char) ( 'a' + i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().commonChars(new String[]{
                "bella", "label", "roller"
        })); // [e,l,l]
        System.out.println(new Solution1().commonChars(new String[]{
                "cool","lock","cook"
        })); // [c, o]
    }
}
