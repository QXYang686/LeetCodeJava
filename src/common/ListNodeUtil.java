package common;

import java.util.LinkedList;
import java.util.List;

public class ListNodeUtil {
    public static ListNode buildLinkedList(Integer[] values) {
        ListNode head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            head = new ListNode(values[i], head);
        }
        return head;
    }

    public static List<Integer> buildArray(ListNode head) {
        LinkedList<Integer> ans = new LinkedList<>();
        while (head != null) {
            ans.add(head.val);
            head = head.next;
        }
        return ans;
    }

    public static boolean equals(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null ? true : false;
    }
}
