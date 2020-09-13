package problem5512;

import java.util.Arrays;

public class Solution1 {
    private boolean xUnhappy(int x, int y, int u, int v, int[][] priority) {
        return priority[x][u] > priority[x][y] && priority[u][x] > priority[u][v]
                || priority[x][v] > priority[x][y] && priority[v][x] > priority[v][u];
    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] priority = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < preferences[i].length; ++j) {
                priority[i][preferences[i][j]] = n - j;
            }
        }
        boolean[] unhappy = new boolean[n];
        for (int i = 0; i < pairs.length; ++i) {
            for (int j = i + 1; j < pairs.length; ++j) {
                int x = pairs[i][0], y = pairs[i][1];
                int u = pairs[j][0], v = pairs[j][1];
                unhappy[x] |= xUnhappy(x,y,u,v, priority);
                unhappy[y] |= xUnhappy(y,x,u,v, priority);
                unhappy[u] |= xUnhappy(u,v,x,y, priority);
                unhappy[v] |= xUnhappy(v,u,x,y, priority);
            }
        }
        int unhappyCount = 0;
        for (boolean i : unhappy) {
            unhappyCount += i ? 1 : 0;
        }
        return unhappyCount;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().unhappyFriends(4, new int[][]{{1,2,3},{3,2,0},{3,1,0},{1,2,0}},new int[][]{{0,1},{2,3}})); // 2
    }
}
