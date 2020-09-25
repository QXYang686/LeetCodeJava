package problem106;

import common.TreeNode;
import common.TreeUtil;

import java.util.Arrays;
import java.util.HashMap;

public class Solution2 {
    private HashMap<Integer, Integer> inorderIndex = new HashMap<>();

    private TreeNode build(int[] inorder, int[] postorder, int inFrom, int inTo, int postFrom, int postTo) {
        if (inFrom >= inTo) return null;
        int rootVal = postorder[postTo - 1];
        int inRootIndex = inorderIndex.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, postorder, inFrom, inRootIndex, postFrom, postFrom + (inRootIndex - inFrom));
        root.right = build(inorder, postorder, inRootIndex + 1, inTo, postFrom + (inRootIndex - inFrom), postTo - 1);
        return root;
    }

    /**
     * 使用哈希表降低根节点搜索的时间复杂度，并通过下表指定范围省掉复制
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        };
        return build(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TreeUtil.buildArray(new Solution2().buildTree(
                new int[]{9, 3, 15, 20, 7},
                new int[]{9, 15, 7, 20, 3}
        )))); // [3,9,20,null,null,15,7]
    }
}
