package probleam77;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution1 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // 利用栈开始回溯法
        Stack<Integer> valueStack = new Stack<>();
        for (int i = 1;; ++i) {
            // 超出范围,回溯
            if (i > n) {
                if (valueStack.size() == 0) break;
                i = valueStack.pop();
                continue;
            }
            valueStack.push(i);
            // 已满k个,输出并退栈
            if (valueStack.size() == k) {
                res.add(new ArrayList<>(valueStack));
                valueStack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().combine(4,2));
    }
}
