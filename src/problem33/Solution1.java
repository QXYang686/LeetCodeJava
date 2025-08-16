package problem33;

public class Solution1 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[l] == target) return l;
            if (nums[mid] == target) return mid;
            if (nums[r] == target) return r;
            if (nums[l] < nums[mid]) {
                if (nums[l] < target && nums[mid] > target) r = mid - 1;
                else l = mid + 1;
            } else {
                if (nums[l] < target || nums[mid] > target) r = mid - 1;
                else l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(4 == new Solution1().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(1 == new Solution1().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        System.out.println(-1 == new Solution1().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(-1 == new Solution1().search(new int[]{1}, 0));
        System.out.println(0 == new Solution1().search(new int[]{1}, 1));
    }
}
