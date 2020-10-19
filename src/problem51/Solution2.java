package problem51;

import java.util.*;

public class Solution2 {
    // 官方方法二：基于位运算的回溯
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        // 使用位运算保存结果列、斜线的落子情况进行回溯
        solve(solutions, queens, n, 0, 0, 0, 0);
        return solutions;
    }

    private void solve(List<List<String>> solutions, int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {
        // 回溯完成，返回结果
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
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
                solve(solutions, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
                // 收子
                queens[row] = -1;
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

}
