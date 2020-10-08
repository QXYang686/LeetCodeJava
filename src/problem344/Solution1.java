package problem344;

public class Solution1 {
    public void reverseString(char[] s) {
        if (s.length == 0) return;
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public static void main(String[] args) {
        char[] seq = "hello".toCharArray();
        new Solution1().reverseString(seq);
        System.out.println(seq);
    }
}
