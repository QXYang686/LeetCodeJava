package problem61;

import common.ListNode;

import java.util.ArrayList;

public class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ArrayList<ListNode> nodes = new ArrayList<>();
        // 保存为ArrayList
        ListNode p = head;
        while (p != null) {
            nodes.add(p);
            p = p.next;
        }
        // 成环
        nodes.get(nodes.size() - 1).next = nodes.get(0);
        // 断开环路并返回结果
        k = k % nodes.size();
        nodes.get((2 * nodes.size() - 1 - k) % nodes.size()).next = null;
        return nodes.get((2 * nodes.size() - 1 - k + 1) % nodes.size());
    }
}
