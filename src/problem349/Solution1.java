package problem349;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Solution1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1HashSet = new HashSet<>();
        Arrays.stream(nums1).forEach(nums1HashSet::add);
        HashSet<Integer> ansSet = new HashSet<>();
        Arrays.stream(nums2).filter(nums1HashSet::contains).forEach(ansSet::add);
        int[] ans = new int[ansSet.size()];
        int i = 0;
        for (int num : ansSet) {
            ans[i++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(new Solution1().intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
