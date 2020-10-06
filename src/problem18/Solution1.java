package problem18;

import java.util.*;

public class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (nums == null || nums.length < 4) return quadruplets;
        Arrays.sort(nums);
        int length = nums.length;
        // 第一个数字
        for (int i = 0; i < length - 3; i++) {
            // 跳过相同元素避免重复
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 最小值大于target，剪枝
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            // 最大值小于target，下一轮
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) continue;
            // 第二个数字
            for (int j = i + 1; j < length - 2; j++) {
                // 跳过相同元素避免重复
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // 最小值大于target，剪枝
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                // 最大值小于target，下一轮
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) continue;
                // 使用双指针优化后两个数的查找时间
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 跳转到下一元素
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        right--;
                    }
                    else if (sum < target) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution1().fourSum(new int[]{1,0,-1,0,-2,2}, 0));
//        System.out.println(new Solution1().fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));
        System.out.println(new Solution1().fourSum(new int[]{-1,0,1,2,-1,-4}, -1));
//        System.out.println(new Solution1().fourSum(new int[]{-489,-487,-471,-464,-451,-421,-414,-405,-396,-355,-354,-350,-336,-335,-334,-307,-298,-296,-295,-287,-267,-256,-247,-231,-170,-130,-120,-109,-96,-80,-78,-71,-63,-56,-44,-43,-13,2,9,18,31,36,39,43,49,49,50,61,68,73,99,107,112,113,120,121,173,180,185,190,203,210,233,246,258,296,319,340,345,370,371,378,395,418,436,444,447,451,460,485},2926));
    }
}
