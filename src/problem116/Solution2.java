package problem116;

public class Solution2 {
    /**
     * 利用已经构建的next指针作层序遍历
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) return null;
        Node elderUncle = root, parent = root;
        while (true) {
            while (parent != null) {
                if (parent.left == null) return root;
                parent.left.next = parent.right;
                parent.right.next = parent.next == null ? null : parent.next.left;
                parent = parent.next;
            }
            parent = elderUncle = elderUncle.left;
        }
    }

    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, node6, node7, null);
        Node node1 = new Node(1, node2, node3, null);
        new Solution2().connect(node1);
        System.out.println(node1);
    }
}
