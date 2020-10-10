package problem142;

import common.ListNode;
import common.ListNodeUtil;

import java.util.HashSet;

public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) fast = fast.next.next;
            else return null;
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.buildLinkedList(new Integer[]{3, 2, 0, 4});
        head.next.next.next.next = head.next;
        head = new Solution2().detectCycle(head);
        System.out.println(head == null ? null : head.val); // 2
        head = ListNodeUtil.buildLinkedList(new Integer[]{1,2});
        head.next.next = head;
        head = new Solution2().detectCycle(head);
        System.out.println(head == null ? null : head.val); // 1
        head = ListNodeUtil.buildLinkedList(new Integer[]{1});
        head = new Solution2().detectCycle(head);
        System.out.println(head == null ? null : head.val); // null
    }
}
