package problem96;

public class Solution1 {
    /**
     * 递归
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n == 0) return 0;
        return dfs(1, n + 1);
    }

    private int dfs(int from, int to) {
        // null
        if (from >= to) return 1;
        int types = 0;
        for (int i = from; i < to; i++) {
            int leftCount = dfs(from, i);
            int rightCount = dfs(i + 1, to);
            types += leftCount * rightCount;
        }
        return types;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().numTrees(3)); // 5
    }
}
