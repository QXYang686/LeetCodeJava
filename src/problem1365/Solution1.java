package problem1365;

import java.util.*;

public class Solution1 {
    /**
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        HashMap<Integer, Integer> valueCounts = new HashMap<>();
        // 对个数字出现字数进行统计
        for (int num : nums) {
            valueCounts.put(num, valueCounts.getOrDefault(num, 0) + 1);
        }
        // 根据数字大小排序
        ArrayList<Map.Entry<Integer, Integer>> sortedValueCounts = new ArrayList<>(valueCounts.entrySet());
        sortedValueCounts.sort(Comparator.comparingInt(Map.Entry::getKey));
        // 得到每个值的答案
        int valueLessCount = 0;
        HashMap<Integer, Integer> valueLessCountMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> sortedValueCount : sortedValueCounts) {
            valueLessCountMap.put(sortedValueCount.getKey(), valueLessCount);
            valueLessCount += sortedValueCount.getValue();
        }
        // 构造答案
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = valueLessCountMap.get(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Solution1().smallerNumbersThanCurrent(
                        new int[]{8, 1, 2, 2, 3}
                        )));
        System.out.println(Arrays.toString(
                new Solution1().smallerNumbersThanCurrent(
                        new int[]{6, 5, 4, 8})));
        System.out.println(Arrays.toString(
                new Solution1().smallerNumbersThanCurrent(
                        new int[]{7, 7, 7, 7})));
    }
}
