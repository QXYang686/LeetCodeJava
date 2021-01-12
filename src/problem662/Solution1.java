package problem662;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    private ArrayList<Long> minList = new ArrayList<>();
    private ArrayList<Long> maxList = new ArrayList<>();

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        minList.add(1L);
        maxList.add(1L);
        dfs(root, 1, 0);
        int ans = 0;
        for (int i = 0; i < minList.size(); i++) {
            ans = Math.max(ans, (int)(maxList.get(i) - minList.get(i)) + 1);
        }
        return ans;
    }

    private void dfs(TreeNode node, long nodeId, int depth) {
        if (node != null) {
            // 确保list[depth]存在
            if (minList.size() <= depth) {
                minList.add(nodeId);
                maxList.add(nodeId);
            }
            // 更新minList、maxList
            minList.set(depth, Math.min(nodeId, minList.get(depth)));
            maxList.set(depth, Math.max(nodeId, maxList.get(depth)));
            // 递归求解
            dfs(node.left, nodeId * 2 - 1, depth + 1);
            dfs(node.right, nodeId * 2, depth + 1);
        }
    }
}
