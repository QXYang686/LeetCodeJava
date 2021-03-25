package problem191;

public class Solution3 {
    // you need to treat n as an unsigned value
    // n&(n - 1)，其运算结果恰为把 n的二进制位中的最低位的 1 变为 0 之后的结果
    public int hammingWeight(int n) {
        // Integer.bitCount
        // HD, Figure 5-2
        // 10 11 11 00 01 10 00 11 01 11 11 10 11 11 11 11
        // 每两位一组计数并将结果写在原位可得
        // 01 10 10 00 01 01 00 10 01 10 10 01 10 10 10 10
        // 实现方式为：(n&0x55555555) + ((n>>>1)&0x55555555), 即奇数位(0/1)+偶数位(0/1)，
        // 0x5 => 0b0101, 奇数位取1时得1，偶数位取1时取0，移位后调转
        // 由pop(x)=x-x/2-x/4-...-x/(2^31)化简可得
        n = n - ((n >>> 1) & 0x55555555);
        // 每四位一组求和并将结果写在原位可得
        // 0011  0010  0010  0010  0011  0011  0100  0100
        // 实现方式为：(n&0x33333333) + ((n>>2)&0x33333333)，即奇数组+偶数组
        // 0x3 => 0b0011，(n&0b0011)可得后两位个数，移两位后可得前两位个数
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        // 每八位一组求和并将结果写w在原位可得
        // 00000101    00000100    00000110    00001000
        // 实现方式为：(n&0x0f0f0f0f) + ((n>>>4)&0x0f0f0f0f)
        // 0x0f => 0b00001111
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        // 每十六位一组求和并将结果写在原位可得
        // 0000,0000,0000,1001     0000,0000,0000,1110
        // 实现方式为：(n&0x00ff00ff) + ((n>>8)&0x00ff00ff)
        // 0x00ff => 0b0000,0000,1111,1111
        n = n + (n >>> 8);
        // 每三十二位一组求和并将结果写在原位可得
        // 0000,0000,0000,0000,0000,0000,0001,0111 即16+4+2+1=23
        // 实现方式为：(n&0x0000ffff) + ((n>>16)&0x0000ffff)
        // 0x0000ffff => 0b0000,0000,0000,0000,1111,1111,1111,1111
        n = n + (n >>> 16);
        // 为了化简运算，高位可能写入了一些垃圾值，执行与运算进行消除
        return n & 0x3f;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().hammingWeight(13)); // 1011, 3
        System.out.println(new Solution3().hammingWeight(128)); // 10000000, 1
        System.out.println(new Solution3().hammingWeight(-3)); // 11111111111111111111111111111101, 31
    }
}
