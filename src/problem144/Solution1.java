package problem144;

import common.TreeNode;
import common.TreeUtil;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    private LinkedList<Integer> ans = new LinkedList<>();

    private void dfs(TreeNode root) {
        if (root == null) return;
        ans.addLast(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().preorderTraversal(TreeUtil.buildTree(new Integer[]{
                1,
                null,2,
                null,null,3
        }))); // [1,2,3]
    }
}
