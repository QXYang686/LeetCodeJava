package problem297;

import common.TreeNode;
import common.TreeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * T -> (T) num (T) | X
 * X 表示空树
 */
public class Codec2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 空树用X表示
        if (root == null) return "X";
        // 递归序列化，每个树用()包裹
        String leftTree = "(" + serialize(root.left) + ")";
        String rightTree = "(" + serialize(root.right) + ")";
        // 返回整棵子树结果
        return leftTree + root.val + rightTree;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] ptr = {0};
        return parse(data, ptr);
    }

    private TreeNode parse(String data, int[] ptr) {
        // X - 空树
        if (data.charAt(ptr[0]) == 'X') {
            ptr[0]++;
            return null;
        }
        // 非空子树(左)num(右)
        TreeNode cur = new TreeNode(0);
        // 左子树
        cur.left = parseSubTree(data, ptr);
        // 当前值
        cur.val = parseInt(data, ptr);
        // 右子树
        cur.right = parseSubTree(data, ptr);
        return cur;
    }

    private int parseInt(String data, int[] ptr) {
        int x = 0, sgn = 1;
        if (!Character.isDigit(data.charAt(ptr[0]))) {
            sgn = -1;
            ptr[0]++;
        }
        while (Character.isDigit(data.charAt(ptr[0]))) {
            x = x * 10 + data.charAt(ptr[0]++) - '0';
        }
        return x * sgn;
    }

    private TreeNode parseSubTree(String data, int[] ptr) {
        // 跳过左括号
        ptr[0]++;
        TreeNode subTree = parse(data, ptr);
        // 跳过右括号
        ptr[0]++;
        return subTree;
    }


    public static void main(String[] args) {
        Codec2 ser = new Codec2();
        Codec2 deser = new Codec2();
        System.out.println(Arrays.asList(1,2,3).toString());
        TreeNode ans = null;//deser.deserialize(ser.serialize(TreeUtil.buildTree(new Integer[]{1,2,3,null,null,4,5})));
//        System.out.println(Arrays.toString(TreeUtil.buildArray(ans)));
        ans = deser.deserialize(ser.serialize(TreeUtil.buildTree(new Integer[]{})));
        ans = deser.deserialize(ser.serialize(TreeUtil.buildTree(new Integer[]{1,null,2,null,null,null,3})));
        System.out.println(Arrays.toString(TreeUtil.buildArray(ans)));
    }
}
