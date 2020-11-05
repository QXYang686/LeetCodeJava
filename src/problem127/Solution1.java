package problem127;

import java.util.*;

public class Solution1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 使用字典构造哈希表实现快速检查
        HashSet<String> availableWords = new HashSet<>(wordList);
        // 结果词不在单词表中，无法转换
        if (!availableWords.contains(endWord)) return 0;
        // 广度优先搜索
        Deque<String> queue = new LinkedList<>();
        queue.push(beginWord);
        int length = 1;
        while (!queue.isEmpty()) {
            // 遍历一层
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String lastWord = queue.poll();
                // 将子节点加入下一层
                Iterator<String> iterator = availableWords.iterator();
                while (iterator.hasNext()) {
                    String nextWord = iterator.next();
                    if (dist(lastWord, nextWord) == 1) {
                        if (nextWord.equals(endWord)) {
                            return length + 1;
                        }
                        queue.offer(nextWord);
                        iterator.remove();
                    }
                }
            }
            length++;
        }
        return 0;
    }

    private int dist(String word1, String word2) {
        int length = 0;
        for (int i = 0; i < word1.length(); i++) {
            length += word1.charAt(i) == word2.charAt(i) ? 0 : 1;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"))); // 5
        System.out.println(new Solution1().ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log"))); // 0
        System.out.println(new Solution1().ladderLength("a", "c", Arrays.asList("a","b","c"))); // 2
    }
}
