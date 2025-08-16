package problem143;

import common.ListNode;
import common.ListNodeUtil;

public class Solution2 {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }
        if (slow == null) return; // 空链表
        ListNode reversed = reverse(slow.next);
        slow.next = null;
        merge(dummy.next, reversed);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(), tail = dummy;
        while (list1 != null || list2 != null) {
            if (list1 != null) {
                ListNode node = list1;
                list1 = list1.next;
                node.next = null;
                tail.next = node;
                tail = tail.next;
            }
            if (list2 != null) {
                ListNode node = list2;
                list2 = list2.next;
                node.next = null;
                tail.next = node;
                tail = tail.next;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = ListNodeUtil.buildLinkedList(new Integer[]{
                1, 2, 3, 4
        });
        new Solution2().reorderList(head1);
        System.out.println(ListNodeUtil.buildArray(head1)); // 1 4 2 3
        ListNode head2 = ListNodeUtil.buildLinkedList(new Integer[]{
                1, 2, 3, 4, 5
        });
        new Solution2().reorderList(head2);
        System.out.println(ListNodeUtil.buildArray(head2)); // 1 5 2 4 3
    }
}
