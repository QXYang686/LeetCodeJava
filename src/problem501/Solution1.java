package problem501;

import common.TreeNode;
import common.TreeUtil;

import java.util.*;

public class Solution1 {
    private HashMap<Integer, Integer> values = new HashMap<>();

    private void dfs(TreeNode root) {
        if (root == null) return;
        values.put(root.val, 1 + values.getOrDefault(root.val, 0));
        dfs(root.left);
        dfs(root.right);
    }

    /**
     * 不利用BST树的特点
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        dfs(root);
        int maxCount = -1;
        LinkedList<Integer> result = new LinkedList<>();
        for (var entry : values.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = new LinkedList<>();
                result.add(entry.getKey());
            } else if (entry.getValue() == maxCount) {
                result.add(entry.getKey());
            }
        }
        int[] finalResult = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            finalResult[i] = result.toArray(new Integer[0])[i];
        }
        return finalResult;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution1().findMode(TreeUtil.buildTree(new Integer[]{1, null, 2, null, null, 2})))); // [2]
//        System.out.println(Arrays.toString(new Solution1().findMode(TreeUtil.buildTree(new Integer[]{-2147483648})))); // [-2147483648]
        System.out.println(Arrays.toString(new Solution1().findMode(TreeUtil.buildTree(new Integer[]{-1,null,2})))); // [-1,2]
    }
}
