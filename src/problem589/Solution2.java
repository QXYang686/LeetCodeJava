package problem589;

import common.Node;

import java.util.*;

public class Solution2 {
    private List<Integer> ans = new LinkedList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return ans;
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Node node5 = new Node(5, Collections.emptyList());
        Node node6 = new Node(6, Collections.emptyList());
        Node node3 = new Node(3, Arrays.asList(node5, node6));
        Node node2 = new Node(2, Collections.emptyList());
        Node node4 = new Node(4, Collections.emptyList());
        Node node1 = new Node(1, Arrays.asList(node3, node2, node4));
        System.out.println(new Solution2().preorder(node1));
    }
}
