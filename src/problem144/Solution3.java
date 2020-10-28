package problem144;

import common.TreeNode;
import common.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    /**
     * Morris遍历
     * 算法描述：
     * 1. 新建临时节点，令该节点为root
     * 2. 当前节点的left为空，将当前节点加入答案，并遍历当前节点的右子节点
     * 3. 如果当前节点的左子节点不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点
     *     * 如果前驱节点的右子节点为空，将前驱节点的右子节点设置为当前节点，然后将当前节点加入答案，
     *       并将当前节点更新为当前节点的子节点
     *     * 如果前驱节点的右子节点为当前节点，将前驱节点的右子节点重新设为空。当前节点更新为当前节点的右子节点
     * 4. 重复步骤2和步骤3，直到遍历结束
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // 保存遍历结果
        List<Integer> ans = new ArrayList<>();
        // 从根节点开始遍历
        TreeNode currentNode = root;
        while (currentNode != null) {
            // 当前节点有左子树，寻找中序下的前驱节点
            // 前驱节点一定在左子树的最右侧路径上
            // 第一次搜索时前驱节点的右子节点应当为null
            // 第二次搜索时由于第一次搜索时已经当前节点接在前驱节点的右子树上，因此右子节点为当前节点
            if (currentNode.left != null) {
                TreeNode preNode = currentNode.left;
                while (preNode.right != null && preNode.right != currentNode) {
                    // preNode.right == null 对应第一次搜索（左子树尚未遍历）
                    // preNode.right == currentNode 对应第二次搜索（左子树遍历完成）
                    preNode = preNode.right;
                }
                // 第一次搜索（左子树尚未遍历）时输出当前节点并在子树进行遍历，
                // 同时将当前节点作为前驱节点的后继节点构造第二次搜索的条件
                if (preNode.right == null) {
                    ans.add(currentNode.val);
                    preNode.right = currentNode;
                    currentNode = currentNode.left;
                }
                // 第二次搜索（左子树遍历完成）时不需要输出（已经输出过），
                // 将前驱节点的右子节点还原为null并开始遍历右子树即可
                // 隐含 if (preNode.right == currentNode)
                else {
                    preNode.right = null;
                    currentNode = currentNode.right;
                }
            }
            // 当前节点没有左子节点，输出当前节点后遍历右子树即可
            else {
                ans.add(currentNode.val);
                currentNode = currentNode.right;
            }
        }
        // 返回答案
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().preorderTraversal(TreeUtil.buildTree(new Integer[]{
                1,
                null,2,
                null,null,3
        }))); // [1,2,3]
    }
}
