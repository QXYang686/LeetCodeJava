package problem190;

public class Solution2 {
    public int reverseBits(int n) {
        // 十六位一组颠倒
        n = ((n & 0x0000ffff) << 16) + ((n >> 16) & 0x0000ffff);
        // 八位一组颠倒
        n = ((n & 0x00ff00ff) << 8) + ((n >> 8) & 0x00ff00ff);
        // 四位一组颠倒
        n = ((n & 0x0f0f0f0f) << 4) + ((n >> 4) & 0x0f0f0f0f);
        // 两位一组颠倒
        n = ((n & 0x33333333) << 2) + ((n >> 2) & 0x33333333);
        // 一位一组颠倒
        n = ((n & 0x55555555) << 1) + ((n >> 1) & 0x55555555);
        // 返回反转结果
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().reverseBits(43261596)); // 964176192
        System.out.println(new Solution2().reverseBits(-3)); // -1073741825
    }
}
