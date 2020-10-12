package problem337;

import common.TreeNode;
import common.TreeUtil;

import java.util.Arrays;

public class Solution1 {
    public int rob(TreeNode root) {
        int[] robbedMoney = dfsRob(root);
        int withRoot = robbedMoney[0], withoutRoot = robbedMoney[1];
        return Math.max(withRoot, withoutRoot);
    }

    private int[] dfsRob(TreeNode root) {
        int[] robbedMoney = new int[2];
        // 空树，抢得0
        if (root == null) return robbedMoney;
        // 左右子树分别抢劫
        int[] robbedFromLeft = dfsRob(root.left);
        int[] robbedFromRight = dfsRob(root.right);
        // 左右子树均不抢劫根节点,则本子树可抢根节点
        int withRoot = robbedFromLeft[1] + robbedFromRight[1] + root.val;
        // 本子树不抢根节点,左右子树均抢最多的
        int withOutRoot = Math.max(robbedFromLeft[0], robbedFromLeft[1]) + Math.max(robbedFromRight[0], robbedFromRight[1]);
        robbedMoney[0] = withRoot;
        robbedMoney[1] = withOutRoot;
        return robbedMoney;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().rob(TreeUtil.buildTree(new Integer[]{ // 7
                3,2,3,null,3,null,1
        })));
        System.out.println(new Solution1().rob(TreeUtil.buildTree(new Integer[]{ // 9
                3,4,5,1,3,null,1
        })));
    }
}
