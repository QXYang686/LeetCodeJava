package problem34;

public class Solution1 {
    /**
     * 单独求左右边界，最后求值
     * 应该可以通过合并在一起求解来提高一定的效率
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int leftBound = leftBound(nums, 0, nums.length - 1, target);
        int rightBound = rightBound(nums, 0, nums.length - 1, target);
        return new int[] { leftBound, rightBound};
    }

    private int leftBound(int[] nums, int left, int right, int target) {
        int minLeft = left, maxRight = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                right = mid - 1;
            }
            else if (target < nums[mid]) {
                right = mid - 1;
            }
            else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        if (left > maxRight || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int rightBound(int[] nums, int left, int right, int target) {
        int minLeft = left, maxRight = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                left = mid + 1;
            }
            else if (target < nums[mid]) {
                right = mid - 1;
            }
            else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        if (right < minLeft || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
