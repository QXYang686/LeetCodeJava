package problem463;

public class Solution1 {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
                    for (int[] direction : directions) {
                        int row = i + direction[0], col = j + direction[1];
                        if (row < 0 || row >= grid.length) perimeter++;
                        else if (col < 0 || col >= grid[0].length) perimeter++;
                        else if (grid[row][col] == 0) perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(new Solution1().islandPerimeter(grid)); // 16
    }
}
