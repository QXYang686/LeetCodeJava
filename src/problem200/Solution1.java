package problem200;

public class Solution1 {
    private int ans = 0;
    // 不动原始数组
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(grid, i, j, visited, false);
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited, boolean fromIsland) {
        // 出界
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]) return;
        // 标记访问痕迹
        visited[i][j] = true;
        if (grid[i][j] == '0') return;
        if (!fromIsland) ans++;
        dfs(grid, i + 1, j, visited, true);
        dfs(grid, i - 1, j, visited, true);
        dfs(grid, i, j + 1, visited, true);
        dfs(grid, i, j - 1, visited, true);
    }
}
