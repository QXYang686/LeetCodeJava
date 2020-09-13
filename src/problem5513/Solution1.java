package problem5513;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution1 {
    private int[] f; // 并查集find数组
    private int find(int x) { // find函数,判断是否同一个root节点
        f[x] = f[x] == x ? x : find(f[x]);
        return f[x];
    }
    private void merge(int x, int y) { // 将树合并
        f[find(x)] = find(y);
    }

    public int minCostConnectPoints(int[][] points) {
        if (points.length < 2) {
            return 0;
        }
        // 构造边堆
        // int[]{ 距离 , 点i, 点j }
        PriorityQueue<int[]> connections = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        for (int i = 0; i < points.length; ++i) {
            for (int j = i + 1; j < points.length; ++j) {
                connections.offer(new int[]{Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]), i , j});
            }
        }
        // 构造森林(并查集)
        f = new int[points.length];
        for (int i = 0; i < f.length; ++i) {
            f[i] = i;
        }
        // 按顺序取出边合并森林
        int length = 0, edge = 0;
        while (edge != points.length - 1) { // 生成树 edge = node - 1
            int[] connection = connections.poll();
            if (find(connection[1]) != find(connection[2])) {
                merge(connection[1], connection[2]);
                length += connection[0];
                ++edge;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}})); // 20
        System.out.println(new Solution1().minCostConnectPoints(new int[][]{{3,12},{-2,5},{-4,1}})); // 18
        System.out.println(new Solution1().minCostConnectPoints(new int[][]{{2,-3},{-17,-8},{13,8},{-17,-15}})); // 53
    }
}
