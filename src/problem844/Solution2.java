package problem844;

public class Solution2 {
    // 从后向前检查
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            // 寻找S、T中最后一个有效字符
            while (i >= 0) {
                if (S.charAt(i) == '#') { skipS++; i--; }
                else if (skipS > 0) { skipS--; i--; }
                else break;
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') { skipT++; j--; }
                else if (skipT > 0) { skipT--; j--; }
                else break;
            }
            // 当前存在有效字符时发现不一致直接返回false
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) return false;
            }
            // 不存在有效字符时若其中一个仍有有效字符则必定不一致
            else {
                if (i >= 0 || j >= 0) return false;
            }
            // 检查下一字符
            i--;
            j--;
        }

        // 检查完毕未发现不一致即一致
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(new Solution2().backspaceCompare("ab##", "c#d#")); // true
        System.out.println(new Solution2().backspaceCompare("a##c", "#a#c")); // true
        System.out.println(new Solution2().backspaceCompare("a#c", "b")); // false
    }
}
