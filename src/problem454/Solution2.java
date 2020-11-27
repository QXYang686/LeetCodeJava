package problem454;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Solution2 {
    /**
     * 通过哈希表减少重复值的计算，超时
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // a的值统计
        HashMap<Integer, Integer> aCount = new HashMap<>();
        for (int a : A) {
            aCount.put(a, aCount.getOrDefault(a, 0) + 1);
        }
        // ab的和统计
        HashMap<Integer, Integer> abCount = new HashMap<>();
        for (int b : B) {
            for (Integer a : aCount.keySet()) {
                int ab = a + b;
                abCount.put(ab, abCount.getOrDefault(ab, 0) + aCount.get(a));
            }
        }
        // abc的和统计
        HashMap<Integer, Integer> abcCount = new HashMap<>();
        for (int c : C) {
            for (Integer ab : abCount.keySet()) {
                int abc = ab + c;
                abcCount.put(abc, abcCount.getOrDefault(abc, 0) + abCount.get(ab));
            }
        }
        int ans = 0;
        for (int d : D) {
            ans += abcCount.getOrDefault(-d, 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2}
        ));
    }
}
