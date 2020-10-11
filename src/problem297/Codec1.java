package problem297;

import common.TreeNode;
import common.TreeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * 先序遍历递归构造
 * 通过None记录空节点信息
 */
public class Codec1 {
    public String reserialize(TreeNode root, String str) {
        if (root == null) str += "None,";
        else {
            str += root.val + ",";
            str = reserialize(root.left, str);
            str = reserialize(root.right, str);
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return reserialize(root, "");
    }

    public TreeNode redeserialize(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(l.get(0)));
        l.remove(0);
        root.left = redeserialize(l);
        root.right = redeserialize(l);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
        return redeserialize(data_list);
    }

    public static void main(String[] args) {
        Codec1 ser = new Codec1();
        Codec1 deser = new Codec1();
        System.out.println(Arrays.asList(1,2,3).toString());
        TreeNode ans = null;//deser.deserialize(ser.serialize(TreeUtil.buildTree(new Integer[]{1,2,3,null,null,4,5})));
//        System.out.println(Arrays.toString(TreeUtil.buildArray(ans)));
        ans = deser.deserialize(ser.serialize(TreeUtil.buildTree(new Integer[]{})));
        ans = deser.deserialize(ser.serialize(TreeUtil.buildTree(new Integer[]{1,null,2,null,null,null,3})));
        System.out.println(Arrays.toString(TreeUtil.buildArray(ans)));
    }
}
