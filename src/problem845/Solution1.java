package problem845;

public class Solution1 {
    public int longestMountain(int[] A) {
        int bottom = 0, peek = 0, ans = 0;
        for (int i = 1; i < A.length - 1; i++) {
            // 到达山顶
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peek = i;
            }
            // 到达山谷时更新记录
            else if (A[i - 1] > A[i] && A[i] < A[i + 1]) {
                // 发现山脉，更新记录
                if (bottom < peek && i > peek) {
                    ans = Math.max(i - bottom + 1, ans);
                }
                // 重置起点
                bottom = peek = i;
            }
            // 发现平地
            else if (A[i] == A[i + 1]) {
                // 发现山脉，更新记录
                if (bottom < peek && i > peek) {
                    ans = Math.max(i - bottom + 1, ans);
                }
                // 重置起点
                bottom = peek = i + 1;
            } else if (A[i - 1] == A[i]) {
                // 发现山脉，更新记录
                if (bottom < peek && i - 1 > peek) {
                    ans = Math.max(i - 1 - bottom + 1, ans);
                }
                bottom = peek = i;
            }
            // 持续上下坡跳过即可
        }
        // 检查最后一次结果
        if (bottom < peek && A.length - 1 > peek) {
            ans = Math.max(A.length - 1 - bottom + 1, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().longestMountain(new int[]{
                2, 1, 4, 7, 3, 2, 5
        })); // 5
        System.out.println(new Solution1().longestMountain(new int[]{
                2, 2, 2
        })); // 0
        System.out.println(new Solution1().longestMountain(new int[]{
                0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0
        })); // 11
        System.out.println(new Solution1().longestMountain(new int[]{
                0,0,1,0,0,1,1,1,1,1
        })); // 3
    }
}
