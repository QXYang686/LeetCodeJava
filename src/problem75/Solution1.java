package problem75;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution1 {
    public void sortColors(int[] nums) {
        int zeroEnd = 0, twoBegin = nums.length;
        for (int i = 0; i < nums.length && i < twoBegin; i++) {
            if (nums[i] == 0) {
                // 交换到最后一个零后方
                nums[i] = nums[zeroEnd];
                nums[zeroEnd++] = 0;
            }
            else if (nums[i] == 1) {
                // 1 不处理
            }
            else if (nums[i] == 2) {
                // 交换到第一个2前方
                nums[i] = nums[--twoBegin];
                nums[twoBegin] = 2;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] sorted = new int[]{2, 0, 2, 1, 1, 0};
        new Solution1().sortColors(sorted);
        System.out.println(Arrays.toString(sorted));
        int[] sorted1 = new int[]{0, 0, 1, 1, 2, 2};
        new Solution1().sortColors(sorted1);
        System.out.println(Arrays.toString(sorted1));
    }
}
