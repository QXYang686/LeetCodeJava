package problem105;

import common.TreeNode;
import common.TreeUtil;

import java.util.Arrays;
import java.util.HashMap;

public class Solution1 {
    private HashMap<Integer, Integer> valueIndex = new HashMap<>();

    private TreeNode build(int[] preorder, int[] inorder, int preFrom, int preTo, int inFrom, int inTo) {
        if (preFrom >= preTo) return null;
        TreeNode root = new TreeNode(preorder[preFrom]);
        int inRootIndex = valueIndex.get(preorder[preFrom]);
        int leftLength = inRootIndex - inFrom, rightLength = inTo - inRootIndex - 1;
        root.left = build(preorder, inorder, preFrom + 1, preFrom + 1 + leftLength, inFrom, inFrom + leftLength);
        root.right = build(preorder, inorder, preTo - rightLength, preTo, inTo - rightLength, inTo);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valueIndex.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TreeUtil.buildArray(
                new Solution1().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7})
        ))); // [3,9,20,null,null,15,7]
    }
}
