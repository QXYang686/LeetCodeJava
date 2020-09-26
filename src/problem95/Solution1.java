package problem95;

import common.TreeNode;
import common.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return dfs(1, n + 1);
    }

    private List<TreeNode> dfs(int from, int to) {
        List<TreeNode> trees = new LinkedList<>();
        // 没有节点
        if (from >= to) {
            trees.add(null);
            return trees;
        }
        // 根据根节点位置构造数
        for (int i = from; i < to; ++i) {
            List<TreeNode> left = dfs(from, i);
            List<TreeNode> right = dfs(i + 1, to);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    trees.add(root);
                }
            }
        }
        return trees;
    }

    public static void main(String[] args) {
        new Solution1().generateTrees(3).forEach(x -> System.out.println(Arrays.toString(TreeUtil.buildArray(x))));
        new Solution1().generateTrees(0).forEach(x -> System.out.println(Arrays.toString(TreeUtil.buildArray(x))));
    }
}
