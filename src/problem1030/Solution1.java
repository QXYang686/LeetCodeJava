package problem1030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        HashMap<Integer, List<List<Integer>>> buckets = new HashMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int dist = Math.abs(i - r0) + Math.abs(j - c0);
                if (!buckets.containsKey(dist)) {
                    buckets.put(dist, new ArrayList<>());
                }
                buckets.get(dist).add(Arrays.asList(i, j));
            }
        }
        int[][] ans = new int[R * C][2];
        int j = 0;
        for (int i = 0;; i++) {
            if (!buckets.containsKey(i)) break;
            for (List<Integer> point : buckets.get(i)) {
                ans[j][0] = point.get(0);
                ans[j][1] = point.get(1);
                j++;
            }
        }
        return ans;
    }
}
