package problem116;

public class Solution1 {
    private void connectTwoNode(Node n1, Node n2) {
        if (n1 == null) return;
        n1.next = n2;
        connectTwoNode(n1.left, n1.right);
        connectTwoNode(n2.left, n2.right);
        connectTwoNode(n1.right, n2.left);
    }

    /**
     * 递归方法
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root != null) connectTwoNode(root.left, root.right);
        return root;
    }

    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, node6, node7, null);
        Node node1 = new Node(1, node2, node3, null);
        new Solution1().connect(node1);
        System.out.println(node1);
    }
}
