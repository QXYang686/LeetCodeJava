package problem199;

import common.TreeNode;
import common.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    private void dfs(TreeNode root, ArrayList<Integer> path, int level) {
        if (root == null) return;
        if (path.size() == level) path.add(level, root.val);
        dfs(root.right, path, level + 1);
        dfs(root.left, path, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root, path, 0);
        return path;
    }

    public static void main(String[] args) {
        List<Integer> ans = new Solution1().rightSideView(TreeUtil.buildTree(new Integer[]{1, 2, 3, null, 5, null, 4}));
        System.out.println(ans);
    }
}
