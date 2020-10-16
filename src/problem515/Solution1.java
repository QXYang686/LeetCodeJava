package problem515;

import common.TreeNode;
import common.TreeUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1 {
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return Collections.emptyList();
        ans.add(root.val);
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int level) {
        // 空节点结束递归
        if (root == null) return;
        // 当前层未访问过，添加结果
        if (ans.size() <= level) ans.add(root.val);
        // 当前层访问过，更新结果
        else ans.set(level, Math.max(ans.get(level), root.val));
        // 递归更新左右子树
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().largestValues(TreeUtil.buildTree(new Integer[]{
                1, 3, 2, 5, 3, null, 9
        }))); // [1, 3, 9]
    }
}
