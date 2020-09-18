package problem47;

import java.util.*;

public class Solution1 {
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        Deque<Integer> path = new LinkedList<>();
        dfs(nums, visited, path, nums.length);
        return result;
    }

    private void dfs(int[] nums, boolean[] visited, Deque<Integer> path, int left) {
        if (left == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length;) {
            if (visited[i]) {
                ++i;
                continue;
            }
            int curValue = nums[i];
            path.push(curValue);
            visited[i] = true;
            dfs(nums, visited, path, left - 1);
            visited[i] = false;
            path.pop();
            while (i < nums.length && nums[i] == curValue) ++i;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().permuteUnique(new int[]{1, 1, 2})); // [[2, 1, 1], [1, 2, 1], [1, 1, 2]]
    }
}
