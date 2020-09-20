package problem5519;

public class Solution1 {
    public String reorderSpaces(String text) {
        int spaceCount = 0;
        char[] charArray = text.toCharArray();
        for (char c : charArray) spaceCount += c == ' ' ? 1 : 0;
        String[] words = text.trim().split("\\s+");
        StringBuilder separator = new StringBuilder();
        for (int i = 0; words.length != 1 && i < spaceCount / (words.length - 1); ++i) separator.append(' ');
        StringBuilder stringBuilder = new StringBuilder(String.join(separator, words));
        for (int i = 0; i < spaceCount - (words.length - 1) * separator.length(); ++i) stringBuilder.append(' ');
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().reorderSpaces("  this   is  a sentence ")); // "this   is   a   sentence"
        System.out.println(new Solution1().reorderSpaces(" practice   makes   perfect")); // "practice   makes   perfect "
        System.out.println(new Solution1().reorderSpaces("hello   world")); // "hello   world"
        System.out.println(new Solution1().reorderSpaces("  walks  udp package   into  bar a")); // "walks  udp  package  into  bar  a "
        System.out.println(new Solution1().reorderSpaces("a")); // "a"
        System.out.println(new Solution1().reorderSpaces(" a")); // "a "
    }
}
