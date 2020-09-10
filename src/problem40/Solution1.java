package problem40;

import java.util.*;

public class Solution1 {
    private void dfs(int[] candidates, List<List<Integer>> result ,int from, ArrayDeque<Integer> path, int target) {
        // 组合成功,输出并返回
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = from; i < candidates.length;) {
            // 不能继续构造,剪枝
            if (target - candidates[i] < 0) {
                ++i;
                return;
            }
            // 选中当前值
            path.push(candidates[i]);
            dfs(candidates, result, i + 1, path, target - candidates[i]);
            // 寻找下一个不同的数值开始迭代来避免重复
            while (i < candidates.length && candidates[i] == path.peek()) {
                ++i;
            }
            path.pop();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(candidates, result, 0, path, target);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(new Solution1().combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
}
