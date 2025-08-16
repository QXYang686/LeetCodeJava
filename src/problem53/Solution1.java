package problem53;

public class Solution1 {
    // 前缀和
    public int maxSubArray(int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                ans = Math.max(ans, sums[j + 1] - sums[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(6 == new Solution1().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(1 == new Solution1().maxSubArray(new int[]{1}));
        System.out.println(23 == new Solution1().maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
