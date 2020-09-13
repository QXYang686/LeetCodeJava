package problem79;

import java.util.HashSet;

public class Solution1 {
    private char[][] board;
    private String word;

    private HashSet<Integer> pathNode = new HashSet<>(); // rowIndex << 10 + colIndex
    private char valueAtPos(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= board.length || colIndex < 0 || colIndex >= board[0].length) {
            return 0; // 与字符串中的任意字符都不相同
        }
        if (pathNode.contains((rowIndex << 10) + colIndex)) {
            return 0;
        }
        return board[rowIndex][colIndex];
    }

    private boolean dfs(char[][] board, String word, int charIndex, int rowIndex, int colIndex) {
        if (word.length() == charIndex) return true;
        // System.out.println(""+charIndex+","+rowIndex+","+colIndex+","+valueAtPos(rowIndex, colIndex)+","+word.charAt(charIndex));
        if (valueAtPos(rowIndex, colIndex) != word.charAt(charIndex)) return false;
        pathNode.add((rowIndex << 10) + colIndex);
        // 上下左右分别处理
        if (dfs(board, word, charIndex + 1, rowIndex - 1, colIndex)
                || dfs(board, word, charIndex + 1, rowIndex + 1, colIndex)
                || dfs(board, word, charIndex + 1, rowIndex, colIndex - 1)
                || dfs(board, word, charIndex + 1, rowIndex, colIndex + 1))
            return true;
        pathNode.remove((rowIndex << 10) + colIndex);
        return false;
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (dfs(board, word, 0, i, j)) {
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
        System.out.println(new Solution1().exist(board, "ABCCED")); // true
        System.out.println(new Solution1().exist(board, "SEE")); // true
        System.out.println(new Solution1().exist(board, "ABCB")); // false
    }
}
