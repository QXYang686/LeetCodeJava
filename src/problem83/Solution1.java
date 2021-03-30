package problem83;

import common.ListNode;

public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode p = dummy, q = dummy;
        while (p != null) {
            while (q != null && p.val == q.val) q = q.next;
            p.next = q;
            p = p.next;
        }
        return dummy.next;
    }
}
