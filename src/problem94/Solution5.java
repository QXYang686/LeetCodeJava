package problem94;

import common.TreeNode;
import common.TreeUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution5 {
    /**
     * Morris中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeNode currentNode = root;
        while (currentNode != null) {
            // 当前节点左子树为空，输出当前节点后遍历右子树
            if (currentNode.left == null) {
                res.add(currentNode.val);
                currentNode = currentNode.right;
            }
            // 当前节点不为空
            else {
                // 搜索中序遍历下的前驱节点
                TreeNode preNode = currentNode.left;
                // 两种结束条件
                // * 右子树为空表示子树尚未遍历，加入线索并开始遍历左子树
                // * 右子树指向当前节点表示左子树已遍历完成，恢复右节点并开始遍历当前节点的右节点
                while (preNode.right != null && preNode.right != currentNode) {
                    preNode = preNode.right;
                }
                // * 右子树为空表示子树尚未遍历，加入线索并开始遍历左子树
                if (preNode.right == null) {
                    preNode.right = currentNode;
                    currentNode = currentNode.left;
                }
                // * 右子树指向当前节点表示左子树已遍历完成，恢复右节点并开始遍历当前节点的右节点
                else {
                    res.add(currentNode.val);
                    preNode.right = null;
                    currentNode = currentNode.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution5().inorderTraversal(TreeUtil.buildTree(
                new Integer[]{1, null, 2, null, null, 3}
        )));
    }
}
