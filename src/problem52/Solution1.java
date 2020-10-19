package problem52;

import java.util.Arrays;

public class Solution1 {
    private int ans = 0;

    // 官方方法二：基于位运算的回溯
    public int totalNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        // 使用位运算保存结果列、斜线的落子情况进行回溯
        solve(queens, n, 0, 0, 0, 0);
        return ans;
    }

    private void solve(int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {
        // 回溯完成，返回结果
        if (row == n) {
            ans++;
        }
        // 未完成，检查row行位置
        else {
            // 通过位运算快速确认可行位置
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0) {
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                int column = Integer.bitCount(position - 1);
                // 落子
                queens[row] = column;
                // 回溯
                solve(queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
                // 收子
                queens[row] = -1;
            }
        }
    }

}
