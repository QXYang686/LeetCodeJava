package problem701;

import common.TreeNode;

public class Solution2 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode cur = root;
        while (cur.val != val) {
            if (val > cur.val && cur.right != null) cur = cur.right;
            else if (val < cur.val && cur.left != null) cur = cur.left;
            else if (val > cur.val) cur = cur.right = new TreeNode(val);
            else cur = cur.left = new TreeNode(val);
        }
        return root;
    }
}
