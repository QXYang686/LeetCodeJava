package problem92;

import common.ListNode;
import common.ListNodeUtil;

public class Solution1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head), prev = dummy;
        // 找翻转前驱
        for (int i = 0; i < left - 1; i++) prev = prev.next;
        // 中间摘链表长度翻转
        ListNode rTail = prev.next, rDummy = new ListNode();
        for (int i = 0; i < right - left + 1; i++) {
            ListNode node = prev.next;
            prev.next = node.next;
            node.next = rDummy.next;
            rDummy.next = node;
        }
        // 接回
        rTail.next = prev.next;
        prev.next = rDummy.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(ListNodeUtil.equals(
                ListNodeUtil.buildLinkedList(new Integer[]{1, 4, 3, 2, 5}),
                new Solution1().reverseBetween(ListNodeUtil.buildLinkedList(new Integer[]{1, 2, 3, 4, 5}), 2, 4)));
        System.out.println(ListNodeUtil.equals(
                ListNodeUtil.buildLinkedList(new Integer[]{5}),
                new Solution1().reverseBetween(ListNodeUtil.buildLinkedList(new Integer[]{5}), 1, 1)));
    }
}
