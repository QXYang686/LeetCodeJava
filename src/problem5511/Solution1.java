package problem5511;

public class Solution1 {
    public int numSpecial(int[][] mat) {
        int[] rowCount = new int[mat.length];
        int[] colCount = new int[mat[0].length];
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                rowCount[i] += mat[i][j];
                colCount[j] += mat[i][j];
            }
        }
        int specialCount = 0;
        for (int i = 0; i < rowCount.length; ++i) {
            for (int j = 0; j < colCount.length; ++j) {
                specialCount += (mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) ? 1 : 0;
            }
        }
        return specialCount;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().numSpecial(new int[][]{{1,0,0},{0,0,1},{1,0,0}})); // 1
        System.out.println(new Solution1().numSpecial(new int[][]{{1,0,0},{0,1,0},{0,0,1}})); // 3
        System.out.println(new Solution1().numSpecial(new int[][]{{0,0,0,1},{1,0,0,0},{0,1,1,0},{0,0,0,0}})); // 2
    }
}
