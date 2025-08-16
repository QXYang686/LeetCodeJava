package problem200;

public class Solution3 {
    // 动原始数组，将岛全部缩小成一个点（i,j最小的点）（针对性的并查集）
    // 不可行：对于L型岛屿，切割拐角后会变成2个独立岛屿
    public int numIslands(char[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] == '1') {
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') grid[i][j] = '0';
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') grid[i][j] = '0';
                }
            }
        }
        int ans = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] == '1') ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(1 == new Solution3().numIslands(grid));
    }
}
