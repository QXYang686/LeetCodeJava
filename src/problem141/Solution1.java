package problem141;

import common.ListNode;
import common.ListNodeUtil;

public class Solution1 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (true) {
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            if (null == slow || null == fast) return false;
            if (slow == fast) return true;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.buildLinkedList(new Integer[]{3,2,0,4});
//        head.next.next.next.next = head.next;
        System.out.println(new Solution1().hasCycle(head));
    }
}
