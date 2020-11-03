package problem941;

public class Solution1 {
    public boolean validMountainArray(int[] A) {
        // 长度过短
        if (A.length < 3) return false;
        int firstPeek = 0, lastPeek = A.length;
        for (int i = 0; i < A.length - 2 && A[i] < A[i + 1]; i++) firstPeek = i + 1;
        for (int j = A.length - 1; j > 1 && A[j] < A[j - 1]; j--) lastPeek = j - 1;
        return lastPeek == firstPeek;
    }
}
