package problem79;

/**
 * 方法相同，使用偏移量数组的技巧
 */
public class Solution2 {
    private boolean dfs(char[][] board, String word, boolean[][] visited, int charIndex, int row, int col) {
        // 应对四个方向均不可行进时不检查最后一个字符串的问题
        if (charIndex == word.length() - 1) return word.charAt(charIndex) == board[row][col];
        if (word.charAt(charIndex) != board[row][col]) return false;
        visited[row][col] = true;
        int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for (int[] direction : directions) {
            int targetRow = row + direction[0], targetCol = col + direction[1];
            if (targetRow >= 0 && targetRow < board.length && targetCol >= 0 && targetCol < board[0].length && !visited[targetRow][targetCol]) {
                if (dfs(board, word, visited, charIndex + 1, targetRow, targetCol)) return true;
            }
        }
        visited[row][col] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (dfs(board, word, visited, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };
        System.out.println(new Solution2().exist(board, "ABCCED")); // true
        System.out.println(new Solution2().exist(board, "SEE")); // true
        System.out.println(new Solution2().exist(board, "ABCB")); // false
        System.out.println(new Solution2().exist(new char[][]{{'a'}}, "a")); // true
    }
}
