package problem501;

import common.TreeNode;
import common.TreeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    private int cur;
    private int curCount;
    private int mostCount = -1;
    private List<Integer> result = new LinkedList<>();

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        curCount = cur == root.val ? curCount + 1 : 1;
        cur = root.val;
        if (curCount > mostCount) {
            result = new LinkedList<>();
            result.add(cur);
            mostCount = curCount;
        } else if (curCount == mostCount) {
            result.add(cur);
        }
        dfs(root.right);
    }


    public int[] findMode(TreeNode root) {
        curCount = 0;
        if (root != null) cur = root.val;
        dfs(root);
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2().findMode(TreeUtil.buildTree(new Integer[]{1, null, 2, null, null, 2})))); // [2]
        System.out.println(Arrays.toString(new Solution2().findMode(TreeUtil.buildTree(new Integer[]{-2147483648})))); // [-2147483648]
        System.out.println(Arrays.toString(new Solution2().findMode(TreeUtil.buildTree(new Integer[]{-1,null,2})))); // [-1,2]
    }
}
