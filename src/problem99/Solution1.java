package problem99;

import common.TreeNode;
import common.TreeUtil;

import java.util.Arrays;

public class Solution1 {
    private TreeNode preNode, curNode;
    private TreeNode firstNode, lastNode;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp = firstNode.val;
        firstNode.val = lastNode.val;
        lastNode.val = temp;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        preNode = curNode;
        curNode = root;
        if (preNode != null) {
            if (preNode.val >= curNode.val) {
                // Note firstNode != null 时已完成，可以剪枝
                firstNode = firstNode == null ? preNode : firstNode;
                lastNode = curNode;
            }
        }
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeUtil.buildTree(new Integer[]{1, 3, null, null, 2});
        new Solution1().recoverTree(t1);
        System.out.println(Arrays.toString(TreeUtil.buildArray(t1))); // [3,1,null,null,2]
        TreeNode t2 = TreeUtil.buildTree(new Integer[]{3,1,4,null,null,2});
        new Solution1().recoverTree(t2);
        System.out.println(Arrays.toString(TreeUtil.buildArray(t2))); // [2,1,4,null,nul,3]
    }
}
