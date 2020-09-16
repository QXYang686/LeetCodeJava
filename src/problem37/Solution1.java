package problem37;

public class Solution1 {
    /**
     * 复杂度过高,没有结果
     * @param board
     * @return
     */
    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') continue;
                boolean[] visited = new boolean[9];
                for (int k = 0; k < 9; ++k) {
                    if (board[i][k] != '.')
                        visited[board[i][k] - '1'] = true;
                }
                for (int k = 0; k < 9; ++k) {
                    if (board[k][j] != '.')
                        visited[board[k][j] - '1'] = true;
                }
                for (int u = 0; u < 3; ++u) {
                    for (int v = 0; v < 3; ++v) {
                        if (board[(i / 3) * 3 + u][(j / 3) * 3 + v] != '.')
                            visited[board[(i / 3) * 3 + u][(j / 3) * 3 + v] - '1'] = true;
                    }
                }
                boolean available = false;
                for (int k = 0; k < 9; ++k) {
                    if (!visited[k]) available = true;
                }
                if (!available) return false;
                for (int k = 0; k < 9; ++k) {
                    if (!visited[k]) {
                        board[i][j] = (char) ('1' + k);
                        print(board);
                        if (solve(board)) return true;
                        board[i][j] = '.';
                    }
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private void print(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        Solution1 solution1 = new Solution1();
        solution1.solveSudoku(board);
        solution1.print(board);
    }
}
