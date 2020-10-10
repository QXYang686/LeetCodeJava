package problem142;

import common.ListNode;
import common.ListNodeUtil;

import java.util.HashSet;

public class Solution1 {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) return head;
            visited.add(head);
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.buildLinkedList(new Integer[]{3, 2, 0, 4});
        head.next.next.next.next = head.next;
        head = new Solution1().detectCycle(head);
        System.out.println(head == null ? null : head.val);
        head = ListNodeUtil.buildLinkedList(new Integer[]{1,2});
        head.next.next = head;
        head = new Solution1().detectCycle(head);
        System.out.println(head == null ? null : head.val);
        head = ListNodeUtil.buildLinkedList(new Integer[]{1});
        head = new Solution1().detectCycle(head);
        System.out.println(head == null ? null : head.val);
    }
}
