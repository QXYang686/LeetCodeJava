package problem377;

import java.util.Arrays;
import java.util.HashMap;

public class Solution2 {
    private HashMap<Integer, Integer> memory = new HashMap<>();

    // 记忆化搜索
    public int combinationSum4(int[] nums, int target) {
        // 排序,尽快剪枝
        Arrays.sort(nums);
        return availableCount(nums, target);
    }

    private int availableCount(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        // 已经存在记录,直接读取
        if (memory.containsKey(target)) {
            return memory.get(target);
        }
        // 不存在记忆,构造
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (target < nums[i]) break;
            count += availableCount(nums, target - nums[i]);
        }
        memory.put(target, count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().combinationSum4(new int[]{1,2,3}, 4)); // 7
        System.out.println(new Solution2().combinationSum4(new int[]{2,1,3}, 35)); // 超时
    }
}
