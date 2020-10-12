package problem429;

import common.Node;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> levelOrder(Node root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                Node node = queue.poll();
                if (node.children != null) queue.addAll(node.children);
                level.offerLast(node.val);
            }
            ans.offerLast(level);
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
        System.out.println(new Solution1().levelOrder(node1));
    }
}
