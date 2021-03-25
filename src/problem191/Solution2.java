package problem191;

public class Solution2 {
    // you need to treat n as an unsigned value
    // n&(n - 1)，其运算结果恰为把 n的二进制位中的最低位的 1 变为 0 之后的结果
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().hammingWeight(13)); // 1011, 3
        System.out.println(new Solution2().hammingWeight(128)); // 10000000, 1
        System.out.println(new Solution2().hammingWeight(-3)); // 11111111111111111111111111111101, 31
    }
}
