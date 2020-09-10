package problem39;

import java.util.*;

public class Solution1 {
    private int[] candidates;
    private int target;
    private int sum = 0;
    private List<List<Integer>> result = new ArrayList<>();
    private ArrayDeque<Integer> temp = new ArrayDeque<>();

    private void dfs(int curIndex) {
//        System.out.println("检查的组合: " + temp);
        // 符合条件,记录结果并输出
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        // 从当前位置开始搜索
        for (int i = curIndex; i < candidates.length; ++i) {
            // 剪枝
            if (sum + candidates[i] > target) return;
            // 搜索
            temp.push(candidates[i]);
            sum += candidates[i];
            dfs(i);
            temp.pop();
            sum -= candidates[i];
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 首先进行排序,按顺序搜索避免重复
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        dfs(0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(new Solution1().combinationSum(new int[]{2,3,5}, 8));
    }
}
