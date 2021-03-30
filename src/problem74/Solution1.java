package problem74;public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int minRow = 0, maxRow = matrix.length;
        while (maxRow > minRow + 1) {
            int mid = minRow + (maxRow - minRow) / 2;
            // 所取的值大于目标值，取左侧区间
            if (matrix[mid][0] > target) maxRow = mid;
                // 所取得值等于目标值，返回
            else if (matrix[mid][0] == target) return true;
                // 所取的值小于目标值，继续检查
            else if (matrix[mid][0] < target) minRow = mid;
        }
        int[] row = matrix[minRow];
        int minCol = 0, maxCol = row.length;
        while (maxCol > minCol + 1) {
            int mid = minCol + (maxCol - minCol) / 2;
            if (row[mid] > target) maxCol = mid;
            else if (row[mid] == target) return true;
            else if (row[mid] < target) minCol = mid;
        }
        // 定位后可能没有进行比较，加补丁进行比较
        return matrix[minRow][minCol] == target;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().searchMatrix(new int[][]{{1}}, 1)); // true
        System.out.println(new Solution1().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3)); // true
        System.out.println(new Solution1().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13)); // false
    }
}
