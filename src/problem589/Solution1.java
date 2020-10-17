package problem589;

import common.Node;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    private List<Integer> ans = new LinkedList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return ans;
        ans.add(root.val);
        root.children.forEach(this::preorder);
        return ans;
    }

    public static void main(String[] args) {
        Node node5 = new Node(5, Collections.emptyList());
        Node node6 = new Node(6, Collections.emptyList());
        Node node3 = new Node(3, Arrays.asList(node5, node6));
        Node node2 = new Node(2, Collections.emptyList());
        Node node4 = new Node(4, Collections.emptyList());
        Node node1 = new Node(1, Arrays.asList(node3, node2, node4));
        System.out.println(new Solution1().preorder(node1));
    }
}
