package problem1207;

public class Solution1 {
    public boolean uniqueOccurrences(int[] arr) {
        // 统计数字频次
        int[] numFreq = new int[2001];
        for (int num : arr) {
            numFreq[num + 1000]++;
        }
        // 统计频次的频次
        boolean[] freqOccurred = new boolean[1001];
        for (int freq : numFreq) {
            // 当前数字出现频次为0，跳过
            if (freq == 0) continue;
            // 当前数字出现的频次已经出现过，返回false
            if (freqOccurred[freq]) return false;
            // 记录出现过的频次
            freqOccurred[freq] = true;
        }
        return true;
    }
}
