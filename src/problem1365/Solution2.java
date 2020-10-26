package problem1365;

import java.util.*;

public class Solution2 {
    /**
     * 思路相同，采用数组存储
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[101];
        // 频率计数
        for (int num : nums) {
            cnt[num]++;
        }
        // 统计小于的次数
        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
        }
        // 构造结果
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Solution2().smallerNumbersThanCurrent(
                        new int[]{8, 1, 2, 2, 3}
                        )));
        System.out.println(Arrays.toString(
                new Solution2().smallerNumbersThanCurrent(
                        new int[]{6, 5, 4, 8})));
        System.out.println(Arrays.toString(
                new Solution2().smallerNumbersThanCurrent(
                        new int[]{7, 7, 7, 7})));
    }
}
