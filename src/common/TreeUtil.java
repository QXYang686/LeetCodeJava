package common;

public class TreeUtil {
    public static TreeNode buildTree(Integer[] values) {
        if (values.length == 0) return null;
        TreeNode[] nodes = new TreeNode[values.length];
        for (int i = 0; i < values.length; ++i) {
            if (values[i] == null) continue;
            nodes[i] = new TreeNode(values[i]);
            // 维护节点关系
            if (i != 0) {
                if (i % 2 == 0) nodes[(i - 1) / 2].right = nodes[i];
                else nodes[(i - 1) / 2].left = nodes[i];
            }
        }
        return nodes[0];
    }
}
