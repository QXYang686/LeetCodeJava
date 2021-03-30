package problem190;

public class Solution1 {
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if (((1 << i) & n) != 0) {
                ret = ret | (1 << (31 - i));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().reverseBits(43261596)); // 964176192
        System.out.println(new Solution1().reverseBits(-3)); // -1073741825
    }
}
