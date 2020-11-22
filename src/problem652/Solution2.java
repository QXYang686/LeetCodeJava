package problem652;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution2 {
    private int t;
    private HashMap<String, Integer> trees = new HashMap<>();
    private HashMap<Integer, Integer> count = new HashMap<>();
    private List<TreeNode> ans = new ArrayList<>();

    /**
     * 唯一标识符，与方案1的区别主要是减少了大量字符串拼接的工作
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        lookup(root);
        return ans;
    }

    private int lookup(TreeNode root) {
        if (root == null) return 0;
        String serial = root.val + "," + lookup(root.left) + "," + lookup(root.right);
        int uid = trees.computeIfAbsent(serial, x -> t++); // 序列化后转为标识符
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2) ans.add(root);
        return uid;
    }
}
