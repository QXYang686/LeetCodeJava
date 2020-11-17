package problem46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {
    private List<List<Integer>> ans = new ArrayList<>();

    /**
     * 回溯法，使用交换的方式节约了visited数组的空间
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<Integer> output = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        backtrack(nums.length, output, 0);
        return ans;
    }

    private void backtrack(int n, ArrayList<Integer> output, int first) {
        // 所有数都填完了
        if (first == n) {
            ans.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

}
