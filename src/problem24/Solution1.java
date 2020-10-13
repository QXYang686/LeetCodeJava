package problem24;

import common.ListNode;
import common.ListNodeUtil;

public class Solution1 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode newHead = head.next;
        ListNode pre = new ListNode(), p = head, q = head.next;
        while (p != null && q != null) {
            // 记录下次结果便于更新
            ListNode nextP = q.next, nextQ = q.next != null ? q.next.next : null;
            // 更新当前两个节点的连接
            pre.next = q;
            q.next = p;
            p.next = nextP;
            // 更新结果
            pre = p;
            p = nextP;
            q = nextQ;
        }
        return newHead;
    }

    public static void main(String[] args) {
        System.out.println(ListNodeUtil.buildArray(new Solution1().swapPairs(ListNodeUtil.buildLinkedList(new Integer[]{
                1,2,3,4
        })))); // 2,1,4,3
        System.out.println(ListNodeUtil.buildArray(new Solution1().swapPairs(ListNodeUtil.buildLinkedList(new Integer[]{
                1
        })))); // 1
    }
}
