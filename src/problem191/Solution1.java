package problem191;

public class Solution1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().hammingWeight(13)); // 1011, 3
        System.out.println(new Solution1().hammingWeight(128)); // 10000000, 1
        System.out.println(new Solution1().hammingWeight(-3)); // 11111111111111111111111111111101, 31
    }
}
