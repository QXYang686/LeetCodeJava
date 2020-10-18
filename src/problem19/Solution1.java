package problem19;

import common.ListNode;
import common.ListNodeUtil;

public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; ++i) fast = fast.next;
        // 删除头指针
        if (fast == null) return head.next;
        // 前指针行进到最后一个时后指针到达删除元素前方
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(ListNodeUtil.buildArray(new Solution1().removeNthFromEnd(ListNodeUtil.buildLinkedList(new Integer[]{
                1, 2, 3, 4, 5
        }), 1)));
    }
}
