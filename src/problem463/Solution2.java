package problem463;

public class Solution2 {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 1;
        }
        if (grid[row][col] == 2) {
            return 0;
        }
        grid[row][col] = 2;
        int ans = 0;
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for (int[] direction : directions) {
            ans += dfs(grid, row + direction[0], col + direction[1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(new Solution2().islandPerimeter(grid)); // 16
    }
}
