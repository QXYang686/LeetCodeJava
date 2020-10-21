package problem143;

import common.ListNode;
import common.ListNodeUtil;

import java.util.*;

public class Solution1 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        ListNode pre = new ListNode();
        for (int i = 0, j = nodes.size() - 1; i <= j; i++,j--) {
            ListNode p = nodes.get(i), q = nodes.get(j);
            p.next = q.next = null;
            if (p == q) {
                pre.next = p;
            }
            else {
                pre.next = p;
                pre = pre.next;
                pre.next = q;
                pre = pre.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head1 = ListNodeUtil.buildLinkedList(new Integer[]{
                1, 2, 3, 4
        });
        new Solution1().reorderList(head1);
        System.out.println(ListNodeUtil.buildArray(head1)); // 1 4 2 3
        ListNode head2 = ListNodeUtil.buildLinkedList(new Integer[]{
                1, 2, 3, 4, 5
        });
        new Solution1().reorderList(head2);
        System.out.println(ListNodeUtil.buildArray(head2)); // 1 5 2 4 2
    }
}
