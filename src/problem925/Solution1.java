package problem925;

public class Solution1 {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) return false;
        int i = 0, j = 0;
        for (; i < name.length() && j < typed.length();) {
            // 提取首字符
            char nameChar = name.charAt(i), typedChar = typed.charAt(j);
            // 字符不同一定不同
            if (nameChar != typedChar) return false;
            // 检查字符出现次数关系
            int nameCount = 0, typedCount = 0;
            while (i < name.length() && name.charAt(i) == nameChar) { i++; nameCount++; }
            while (j < typed.length() && typed.charAt(j) == typedChar) { j++; typedCount++; }
            if (nameCount > typedCount) return false;
        }
        return i == name.length() && j == typed.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().isLongPressedName("alex", "aaleex"));
        System.out.println(new Solution1().isLongPressedName("saeed", "ssaaedd"));
        System.out.println(new Solution1().isLongPressedName("leelee", "lleeelee"));
        System.out.println(new Solution1().isLongPressedName("laiden", "laiden"));
    }
}
