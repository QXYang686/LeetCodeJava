package problem242;

import java.util.List;
import java.util.stream.Collectors;

public class Solution1 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        List<Integer> sList = s.codePoints().boxed().sorted().collect(Collectors.toList());
        List<Integer> tList = t.codePoints().boxed().sorted().collect(Collectors.toList());
        for (int i = 0; i < sList.size(); i++) {
            if (!sList.get(i).equals(tList.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().isAnagram("anagram", "nagaram")); // true
        System.out.println(new Solution1().isAnagram("rat", "car")); // false
    }
}
