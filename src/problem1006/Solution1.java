package problem1006;

public class Solution1 {
    /**
     * 去除第一组a*b/c后的公式可统一为+a-b*c/d
     * 以此方式迭代即可
     */
    public int clumsy(int N) {
        // 不超过4的情况下直接返回结果
        int[] ans = new int[]{0, 1, 2, 6};
        if (N <= 3) return ans[N];
        // 去除第一组*/
        int ret = N * (N - 1) / (N - 2);
        N = N - 3;
        // 剩余值+-*/一组计算即可
        while (N > 0) {
            ret += group(N);
            N -= 4;
        }
        // 完成计算
        return ret;
    }

    // + - * / 顺序下的一组
    private int group(int N) {
        // N < 3, 结果全为1
        if (N <= 3) return 1;
        // 否则直接计算即可
        return N - (N - 1) * (N - 2) / (N - 3);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().clumsy(2)); // 2
        System.out.println(new Solution1().clumsy(4)); // 7
        System.out.println(new Solution1().clumsy(10)); // 12
    }
}
