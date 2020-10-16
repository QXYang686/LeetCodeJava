package problem977;

import java.util.Arrays;

public class Solution1 {
    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        int first = 0, last = A.length - 1;
        for (int i = A.length - 1; i >= 0; --i) {
            int squareFirst = A[first] * A[first], squareLast = A[last] * A[last];
            if (squareFirst < squareLast) {
                ans[i] = squareLast;
                last--;
            }
            else {
                ans[i] = squareFirst;
                first++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(new Solution1().sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }
}
