package problem559;

import common.Node;

import java.util.Arrays;
import java.util.Collections;

public class Solution1 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int maxChildDepth = 0;
        for (Node node : root.children) {
            maxChildDepth = Math.max(maxChildDepth, maxDepth(node));
        }
        return maxChildDepth + 1;
    }

    public static void main(String[] args) {
        Node node5 = new Node(5, Collections.emptyList());
        Node node6 = new Node(6, Collections.emptyList());
        Node node3 = new Node(3, Arrays.asList(node5, node6));
        Node node2 = new Node(2, Collections.emptyList());
        Node node4 = new Node(4, Collections.emptyList());
        Node node1 = new Node(1, Arrays.asList(node3, node2, node4));

        System.out.println(new Solution1().maxDepth(node1)); // 3
    }
}
