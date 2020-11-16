package problem509;

import java.util.HashMap;

class Solution2 {
    private HashMap<Integer, Integer> memo = new HashMap<>();
    /**
     * 递归，通过备忘录剪枝消除重复子问题
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        if (!memo.containsKey(N)) {
            memo.put(N, fib(N - 1) + fib(N - 2));
        }
        return memo.get(N);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().fib(2)); // 1
    }
}
