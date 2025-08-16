package problem215;

public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        int i = l, j = r - 1, pivot = nums[j];
        while (i < j) {
            while (i < j && nums[i] <= pivot) i++;
            if (i < j) nums[j--] = nums[i];
            while (i < j && nums[j] >= pivot) j--;
            if (i < j) nums[i++] = nums[j];
        }
        nums[i] = pivot;
        while (i - 1 >= l && nums[i] == nums[i - 1]) i--;
        while (j + 1 < r && nums[j] == nums[j + 1]) j++;
        if (i <= k && j >= k) return nums[k];
        else if (i > k) return quickSelect(nums, l, i, k);
        else if (j < k) return quickSelect(nums, j + 1, r, k);
        else throw new RuntimeException("unreachable");
    }

    public static void main(String[] args) {
        int case1 = new Solution2().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(case1 == 5);
        int case2 = new Solution2().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println(case2 == 4);
    }
}
