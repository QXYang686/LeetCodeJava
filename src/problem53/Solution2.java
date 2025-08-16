package problem53;

public class Solution2 {
    // dp1[0:i] = max(dp1[0:i-1]+nums[i],nums[i]) [0,i] 范围内包含 i 的最大和
    // dp2[0:i] = max(dp1[0:i-1],dp2[0:i-1]) [0,i] 范围内不包含 i 的最大和
    // dp1[0:i]、dp2[0:i] 只与 dp1[0:i-1]、dp2[0:i-1] 相关，状态可以压缩
    public int maxSubArray(int[] nums) {
        int dp1 = nums[0], dp2 = -10_000 - 1;
        for (int i = 1; i < nums.length; i++) {
            int ndp1 = Math.max(dp1 + nums[i], nums[i]);
            int ndp2 = Math.max(dp1, dp2);
            dp1 = ndp1;
            dp2 = ndp2;
        }
        return Math.max(dp1, dp2);
    }

    public static void main(String[] args) {
        System.out.println(6 == new Solution2().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(1 == new Solution2().maxSubArray(new int[]{1}));
        System.out.println(23 == new Solution2().maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
