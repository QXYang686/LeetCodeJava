package problem117;

public class Solution1 {
    public Node connect(Node root) {
        if (root == null) return null;
        Node parent = root, elderBrother = null, brother = null;
        while (parent != null) {
            elderBrother = brother = null;
            // 一层
            while (parent != null) {
                System.out.println(parent.val);
                // 无节点,跳过
                if (parent.left == null && parent.right == null) {} // do nothing
                // 只有左节点
                else if (parent.left != null && parent.right == null) {
                    if (brother == null) elderBrother = brother = parent.left;
                    else brother.next = parent.left;
                }
                // 只有右节点
                else if (parent.left == null && parent.right != null) {
                    if (brother == null) elderBrother = brother = parent.right;
                    else brother.next = parent.right;
                }
                // 左右都有
                else {
                    parent.left.next = parent.right;
                    if (brother == null) elderBrother = brother = parent.left;
                    else brother.next = parent.left;
                }
                // 当前节点前移
                while (brother != null && brother.next != null) brother = brother.next;
                parent = parent.next;
            }
            // 跳到下一层
            parent = elderBrother;
        }
        return root;
    }

    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, null, node7, null);
        Node node1 = new Node(1, node2, node3, null);
        new Solution1().connect(node1);
        System.out.println(node1);
    }
}
