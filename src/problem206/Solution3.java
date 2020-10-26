package problem206;

import common.ListNode;
import common.ListNodeUtil;

public class Solution3 {
    /**
     * 递归法2
     * 当前节点后的链表逆转后当前节点的后继即在逆转链表的表尾
     * 因此可以快速将当前节点链接到逆转后的节点上
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        System.out.println(ListNodeUtil.buildArray(new Solution3().reverseList(ListNodeUtil.buildLinkedList(new Integer[]{
                        1, 2, 3, 4, 5
                }))));
    }
}
