package problem54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int l = 0, r = matrix[0].length - 1, u = 0, d = matrix.length - 1;
        while (l <= r && u <= d) {
            for (int i = l; i <= r; i++) ans.add(matrix[u][i]);
            u++;
            if (u > d) break;
            for (int i = u; i <= d; i++) ans.add(matrix[i][r]);
            r--;
            if (l > r) break;
            for (int i = r; i >= l; i--) ans.add(matrix[d][i]);
            d--;
            if (u > d) break;
            for (int i = d; i >= u; i--) ans.add(matrix[i][l]);
            l++;
            if (l > r) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5).equals(new Solution1().spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        })));
        System.out.println(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7).equals(new Solution1().spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        })));
    }
}
