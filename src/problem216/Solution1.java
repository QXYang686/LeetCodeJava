package problem216;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(result, path, 1, k, n);
        return result;
    }

    private void dfs(List<List<Integer>> result, ArrayDeque<Integer> path, int from, int leftK, int leftN) {
        // k,n 均为零,记录并退出
        if (leftK == 0 && leftN == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = from; i <= 9; ++i) {
            // 剪枝
            if (leftN < i) {
                break;
            }
            path.push(i);
            dfs(result, path, i + 1, leftK - 1, leftN - i);
            path.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().combinationSum3(3,7)); // [[1,2,4]]
        System.out.println(new Solution1().combinationSum3(3,9)); // [[1,2,6],[1,3,5],[2,3,4]]
    }
}
