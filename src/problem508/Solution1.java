package problem508;

import common.TreeNode;
import common.TreeUtil;

import java.util.*;

public class Solution1 {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        HashMap<Integer, Integer> sumCount = new HashMap<>();
        dfs(root, sumCount);
        int maxCount = 0;
        List<Integer> ans = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : sumCount.entrySet()) {
            if (entry.getValue() < maxCount) continue;
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                ans = new LinkedList<>();
            }
            ans.add(entry.getKey());
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(TreeNode root, HashMap<Integer, Integer> sumCount) {
        if (root == null) return 0;
        // 左右子树递归求解
        int leftSum = dfs(root.left, sumCount);
        int rightSum = dfs(root.right, sumCount);
        // 当前子树处理
        sumCount.put(root.val + leftSum + rightSum, sumCount.getOrDefault(root.val + leftSum + rightSum, 0) + 1);
        return root.val + leftSum + rightSum;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().findFrequentTreeSum(TreeUtil.buildTree(new Integer[]{
                5, 2, -3
        })))); // [2, -3, 4]
        System.out.println(Arrays.toString(new Solution1().findFrequentTreeSum(TreeUtil.buildTree(new Integer[]{
                5, 2, -5
        })))); // [2]
    }
}
