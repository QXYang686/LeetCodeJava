package problem46;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(path, visited, nums);
        return ans;
    }

    void backtrack(List<Integer> path, boolean[] visited, int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                path.add(nums[i]);
                visited[i] = true;
                backtrack(path, visited, nums);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
