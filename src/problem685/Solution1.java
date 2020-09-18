package problem685;

import java.util.*;

public class Solution1 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodesCount = edges.length;
        UnionFind unionFind = new UnionFind(nodesCount + 1);
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; ++i) parent[i] = i;
        int conflict = -1, cycle = -1;
        for (int i = 0; i < edges.length; ++i) {
            int[] edge = edges[i];
            int from = edge[0], to = edge[1];
            if (parent[to] != to) {
                conflict = i;
            }
            else {
                parent[to] = from;
                if (unionFind.find(from) == unionFind.find(to)) {
                    cycle = i;
                }
                else {
                    unionFind.union(from, to);
                }
            }
        }
        if (conflict < 0) {
            int[] redundant = {edges[cycle][0], edges[cycle][1]};
            return redundant;
        }
        else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                return redundant;
            }
            else {
                int[] redundant = {conflictEdge[0], conflictEdge[1]};
                return redundant;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}}))); // [2,3]
        System.out.println(Arrays.toString(new Solution1().findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}}))); // [4,1]
    }
}
