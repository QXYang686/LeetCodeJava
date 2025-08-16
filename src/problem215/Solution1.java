package problem215;

public class Solution1 {
    // 堆排序
    public int findKthLargest(int[] nums, int k) {
        buildMaxHeap(nums);
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = nums[0];
            nums[0] = temp;
            heapify(nums, nums.length - 1 - i, 0);
        }
        return nums[nums.length - k];
    }

    private void buildMaxHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }
    }

    private void heapify(int[] nums, int n, int i) {
        int t = i, l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && nums[l] > nums[t]) t = l;
        if (r < n && nums[r] > nums[t]) t = r;
        if (t != i) {
            int temp = nums[i];
            nums[i] = nums[t];
            nums[t] = temp;
            heapify(nums, n, t);
        }
    }

    public static void main(String[] args) {
        int case1 = new Solution1().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(case1 == 5);
        int case2 = new Solution1().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println(case2 == 4);
    }
}
