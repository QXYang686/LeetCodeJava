package problem922;

public class Solution1 {
    public int[] sortArrayByParityII(int[] A) {
        int oddError = 1, evenError = 0;
        while (oddError < A.length && evenError < A.length) {
            while (oddError < A.length && A[oddError] % 2 == 1) oddError += 2;
            while (evenError < A.length && A[evenError] % 2 == 0) evenError += 2;
            if (oddError < A.length && evenError < A.length) {
                int temp = A[oddError];
                A[oddError] = A[evenError];
                A[evenError] = temp;
            }
        }
        return A;
    }
}
