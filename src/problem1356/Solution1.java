package problem1356;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1 {
    public int[] sortByBits(int[] arr) {
        List<Integer> sortedList = Arrays.stream(arr).boxed().sorted(
                Comparator.comparingInt(Integer::bitCount).thenComparing(Integer::intValue)
        ).collect(Collectors.toList());
        int[] ans = new int[arr.length];
        for (int i = 0; i < sortedList.size(); i++) {
            ans[i] = sortedList.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println(Arrays.toString(new Solution1().sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1})));
    }
}
