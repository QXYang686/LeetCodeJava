package problem57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        // 小于部分
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            i++;
        }
        // 到达新区间部分，合并
        int from = i < intervals.length ? Math.min(intervals[i][0], newInterval[0]) : newInterval[0], end = newInterval[1];
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            end = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ans.add(Arrays.asList(from, end));
        // 大于部分
        while (i < intervals.length) {
            ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            i++;
        }
        // 转数组输出
        int[][] ret = new int[ans.size()][2];
        for (int j = 0; j < ans.size(); j++) {
            ret[j][0] = ans.get(j).get(0);
            ret[j][1] = ans.get(j).get(1);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution1().insert(
                new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}
        ))); // [1,5],[6,9]
        System.out.println(Arrays.deepToString(new Solution1().insert(
                new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4, 8}
        ))); // [[1,2],[3,10],[12,16]]
        System.out.println(Arrays.deepToString(new Solution1().insert(
                new int[][]{}, new int[]{5, 7}
        ))); // [5,7]
    }
}
