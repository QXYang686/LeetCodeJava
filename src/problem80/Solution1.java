package problem80;

public class Solution1 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int i = 0, j = 1, cur = nums[0];
        // 遍历
        while (j < nums.length) {
            // 不重复,直接写入即可
            if (cur != nums[j] || j + 1 == nums.length) {
                nums[++i] = nums[j++];
            }
            // 仅两个重复值,直接写入即可
            else if (cur == nums[j] && cur != nums[j + 1]) {
                nums[++i] = nums[j++];
            }
            // 多于两个重复值，写入后跳到下一个值
            else if (cur == nums[j] && cur == nums[j + 1]) {
                nums[++i] = nums[j++];
                while (j < nums.length && cur == nums[j]) j++;
            }
            cur = nums[i];
        }
        return i + 1;
    }
}
