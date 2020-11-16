package problem509;

class Solution4 {
    /**
     * 动态规划，自底向上，状态压缩减小空间复杂度
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N == 0) return 0;
        int prev = 0, cur = 1;
        for (int i = 1; i < N; i++) {
            int temp = prev + cur;
            prev = cur;
            cur = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().fib(3)); // 2
        System.out.println(new Solution4().fib(2)); // 1
        System.out.println(new Solution4().fib(1)); // 1
        System.out.println(new Solution4().fib(0)); // 0
    }
}
