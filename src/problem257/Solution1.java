package problem257;

import common.TreeNode;
import common.TreeUtil;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    private List<String> ans = new LinkedList<>();

    private void dfs(TreeNode root, StringBuilder path) {
        if (root == null) return;
        path.append("->");
        path.append(Integer.toString(root.val));
        if (root.left == null && root.right == null) {
            ans.add(path.substring(2, path.length()));
        }
        dfs(root.left, path);
        dfs(root.right, path);
        path.delete(path.length() - Integer.toString(root.val).length() - 2, path.length());
    }

    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder path = new StringBuilder();
        dfs(root, path);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().binaryTreePaths(TreeUtil.buildTree(new Integer[]{
                1,2,3,null,5
        })));
    }
}
