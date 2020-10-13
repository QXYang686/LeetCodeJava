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
}
