package problem844;

public class Solution1 {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder s = new StringBuilder(), t = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#' && s.length() != 0) s.deleteCharAt(s.length() - 1);
            else if (S.charAt(i) != '#') s.append(S.charAt(i));
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#' && t.length() != 0) t.deleteCharAt(t.length() - 1);
            else if (T.charAt(i) != '#') t.append(T.charAt(i));
        }
//        System.out.println("s = " + s);
//        System.out.println("t = " + t);
        return s.toString().equals(t.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(new Solution1().backspaceCompare("ab##", "c#d#")); // true
        System.out.println(new Solution1().backspaceCompare("a##c", "#a#c")); // true
        System.out.println(new Solution1().backspaceCompare("a#c", "b")); // false
    }
}
