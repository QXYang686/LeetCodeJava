package problem347;

import java.util.*;

public class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        // 计数
        Map<Integer,Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // 利用小顶堆提取topK
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (Map.Entry<Integer,Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (k == queue.size()) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }

        // 转结果
        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = queue.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Solution1().topKFrequent(new int[]{1,1,1,2,2,3}, 2)
        ));
    }
}
