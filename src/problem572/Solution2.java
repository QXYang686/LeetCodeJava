package problem572;

import common.TreeNode;
import common.TreeUtil;

import java.util.Objects;

public class Solution2 {
    private int targetHash;
    private boolean success = false;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        targetHash = treeHash(t);
        dfsHash(s, t);
        return success;
    }

    // 递归检查+提前终止
    private int dfsHash(TreeNode s, TreeNode t) {
        // 空树终止
        if (s == null) return 0;
        // 左子树哈希
        int leftHash = dfsHash(s.left, t);
        if (success) return 0;
        // 右子树哈希
        int rightHash = dfsHash(s.right, t);
        if (success) return 0;
        // 当前子树哈希
        int rootHash = Objects.hash(s.val, leftHash, rightHash);
        if (rootHash == targetHash && isSameTree(s, t)) success = true;
        if (success) return 0;
        return rootHash;
    }

    // 递归检查同一棵树
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        else if (s != null && t != null) return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        else return false;
    }

    // 计算树哈希
    private int treeHash(TreeNode t) {
        if (t == null) return 0;
        return Objects.hash(t.val, treeHash(t.left), treeHash(t.right));
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isSubtree(
                TreeUtil.buildTree(new Integer[]{
                        3, 4, 5, 1, 2
                }),
                TreeUtil.buildTree(new Integer[]{
                        4, 1, 2
                })
        )); // true
        System.out.println(new Solution2().isSubtree(
                TreeUtil.buildTree(new Integer[]{
                        3, 4, 5, 1, 2, null, null, null, null, 0
                }),
                TreeUtil.buildTree(new Integer[]{
                        4, 1, 2
                })
        )); // false
        System.out.println(new Solution2().isSubtree(
                TreeUtil.buildTree(new Integer[]{
                        1, 1
                }),
                TreeUtil.buildTree(new Integer[]{
                        1
                })
        )); // true
        System.out.println(new Solution2().isSubtree(
                TreeUtil.buildTree(new Integer[]{
                        1
                }),
                TreeUtil.buildTree(new Integer[]{
                        1
                })
        )); // true
    }
}
