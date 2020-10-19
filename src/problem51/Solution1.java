package problem51;

import java.util.*;

public class Solution1 {
    // 官方方法一：基于集合的回溯
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        // 用于快速检查是否冲突的集合
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        // 回溯法
        bactrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    private void bactrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        // 回溯完成，返回结果
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        }
        // 未完成，检查row行位置
        else {
            for (int i = 0; i < n; i++) {
                // 跳过冲突点
                if (columns.contains(i)) continue;
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) continue;
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) continue;
                // 落子
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                // 回溯
                bactrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                // 收子
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
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
