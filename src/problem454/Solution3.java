package problem454;

import java.util.HashMap;

public class Solution3 {
    /**
     * A + B = - (C + D) 分组+哈希
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ans = 0;
        HashMap<Integer, Integer> abCount = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                abCount.merge(a + b, 1, Integer::sum);
            }
        }
        for (int c : C) {
            for (int d : D) {
                ans += abCount.getOrDefault(-(c + d), 0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2}
        ));
    }
}
