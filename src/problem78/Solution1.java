package problem78;

import java.util.*;

public class Solution1 {
    private List<List<Integer>> result = new LinkedList<>();

    private void dfs(int[] nums, Deque<Integer> path, int from) {
        if (from == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        path.push(nums[from]);
        dfs(nums, path, from + 1);
        path.pop();
        dfs(nums, path, from + 1);
    }

    /**
     * 回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        Deque<Integer> path = new LinkedList<>();
        dfs(nums, path, 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().subsets(new int[]{1,2,3}));
    }
}
