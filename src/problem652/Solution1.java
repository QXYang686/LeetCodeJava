package problem652;

import common.TreeNode;

import java.util.*;

public class Solution1 {
    private HashMap<String, Integer> count = new HashMap<>();
    private List<TreeNode> ans = new ArrayList<>();

    /**
     * 深度优先搜索方式进行序列化
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        collect(root);
        return ans;
    }

    private String collect(TreeNode root) {
        if (root == null) return "#";
        String serial = root.val + "," + collect(root.left) + "," + collect(root.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2) ans.add(root);
        return serial;
    }

}
