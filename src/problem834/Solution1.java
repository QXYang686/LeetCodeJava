package problem834;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution1 {
    private void dfs(HashMap<Integer, LinkedList<Integer>> graph, boolean[] visited, int start, int from, int distance, int[] answer) {
        LinkedList<Integer> neighbors = graph.get(from);
        for (int neighbor : neighbors) {
            if (visited[neighbor]) continue;
            answer[start] += (distance + 1);
            visited[neighbor] = true;
            dfs(graph, visited, start, neighbor, distance + 1, answer);
            visited[neighbor] = false;
        }
    }

    /**
     * 直接DFS，超时
     * @param N
     * @param edges
     * @return
     */
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (N == 0) return new int[0];
        if (N == 1) return new int[]{0};
        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int i = edge[0], j = edge[1];
            graph.putIfAbsent(i, new LinkedList<>());
            graph.putIfAbsent(j, new LinkedList<>());
            graph.get(i).add(j);
            graph.get(j).add(i);
        }
        int[] answer = new int[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(graph, visited, i, i, 0, answer);
            visited[i] = false;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}})));
        System.out.println(Arrays.toString(new Solution1().sumOfDistancesInTree(1, new int[][]{})));
    }
}
