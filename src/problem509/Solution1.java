package problem509;

class Solution1 {
    /**
     * 递归
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return fib(N - 1) + fib(N - 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().fib(2)); // 1
    }
}
