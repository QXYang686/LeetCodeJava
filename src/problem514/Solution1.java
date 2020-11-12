package problem514;

import java.util.*;
import java.util.stream.Collectors;

public class Solution1 {
    private ArrayList<List<Integer>> charPositions;

    /**
     * 递归，超时
     * @param ring
     * @param key
     * @return
     */
    public int findRotateSteps(String ring, String key) {
        // 记忆字符可能位置
        charPositions = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            charPositions.add(new ArrayList<>());
        }
        for (int i = 0; i < ring.length(); i++) {
            charPositions.get(ring.charAt(i) - 'a').add(i);
        }
        // 执行搜索
        return findRotateSteps(ring, key, 0);
    }

    private int findRotateSteps(String ring, String key, int currentPos) {
        // 没有字母需要拼写
        if (key.length() == 0) return 0;
        // 所有方案中选择(跳过中间旋转过程,直接到对应值)
        int resultStep = Integer.MAX_VALUE;
        for (Integer targetPos : charPositions.get(key.charAt(0) - 'a')) {
            // 每个目标都有两种合理的旋转方式(顺时针/逆时针)
            int step = Math.min(
                    (targetPos - currentPos + ring.length()) % ring.length(),
                    (currentPos - targetPos + ring.length()) % ring.length()
            ) + 1;
            // 从所有目标中选择步数最少的
            resultStep = Math.min(resultStep, step + findRotateSteps(ring, key.substring(1), targetPos));
        }
        return resultStep;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().findRotateSteps("godding", "gd")); // 4
        System.out.println(new Solution1().findRotateSteps("caotmcaataijjxi", "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx")); // 4
    }
}
