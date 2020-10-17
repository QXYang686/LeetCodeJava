package problem572;

import common.TreeNode;
import common.TreeUtil;

import java.util.*;

public class Solution3 {
    private int maxElement, lNull, rNull;
    private List<Integer> sOrder = new ArrayList<>();
    private List<Integer> tOrder = new ArrayList<>();

    public boolean isSubtree(TreeNode s, TreeNode t) {
        maxElement = Integer.MIN_VALUE;
        getMaxElement(s);
        getMaxElement(t);
        lNull = maxElement + 1;
        rNull = maxElement + 2;

        getDfsOrder(s, sOrder);
        getDfsOrder(t, tOrder);

        return kmp();
    }

    private boolean kmp() {
        int sLen = sOrder.size(), tLen = tOrder.size();
        int[] fail = new int[tOrder.size()];
        Arrays.fill(fail, -1);
        for (int i = 1, j = -1; i < tLen; ++i) {
            while (j != -1 && !(tOrder.get(i).equals(tOrder.get(j + 1)))) j = fail[j];
            if (tOrder.get(i).equals(tOrder.get(j + 1))) ++j;
            fail[i] = j;
        }
        for (int i = 0, j = -1; i < sLen; ++i) {
            while (j != -1 && !(sOrder.get(i).equals(tOrder.get(j + 1)))) j = fail[j];
            if (sOrder.get(i).equals(tOrder.get(j + 1))) ++j;
            if (j == tLen - 1) return true;
        }
        return false;
    }

    private void getDfsOrder(TreeNode t, List<Integer> tar) {
        if (t == null) return;
        tar.add(t.val);
        if (t.left != null) getDfsOrder(t.left, tar);
        else tar.add(lNull);
        if (t.right != null) getDfsOrder(t.right, tar);
        else tar.add(rNull);
    }

    private void getMaxElement(TreeNode t) {
        if (t == null) return;
        maxElement = Math.max(maxElement, t.val);
        getMaxElement(t.left);
        getMaxElement(t.right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().isSubtree(
                TreeUtil.buildTree(new Integer[]{
                        3, 4, 5, 1, 2
                }),
                TreeUtil.buildTree(new Integer[]{
                        4, 1, 2
                })
        )); // true
        System.out.println(new Solution3().isSubtree(
                TreeUtil.buildTree(new Integer[]{
                        3, 4, 5, 1, 2, null, null, null, null, 0
                }),
                TreeUtil.buildTree(new Integer[]{
                        4, 1, 2
                })
        )); // false
        System.out.println(new Solution3().isSubtree(
                TreeUtil.buildTree(new Integer[]{
                        1, 1
                }),
                TreeUtil.buildTree(new Integer[]{
                        1
                })
        )); // true
        System.out.println(new Solution3().isSubtree(
                TreeUtil.buildTree(new Integer[]{
                        1
                }),
                TreeUtil.buildTree(new Integer[]{
                        1
                })
        )); // true
    }
}
