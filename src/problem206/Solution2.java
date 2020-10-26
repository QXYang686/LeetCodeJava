package problem206;

import common.ListNode;
import common.ListNodeUtil;

public class Solution2 {
    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        return reversedListHeadAndTail(head)[0];
    }

    private ListNode[] reversedListHeadAndTail(ListNode head) {
        // 两个节点，直接构造
        if (head.next.next == null) {
            ListNode[] listNodes = new ListNode[]{head.next, head};
            listNodes[0].next = head;
            listNodes[1].next = null;
            return listNodes;
        }
        // 多于两个节点递归构造
        ListNode[] listNodes = reversedListHeadAndTail(head.next);
        head.next = null;
        listNodes[1].next = head;
        return new ListNode[]{listNodes[0], head};
    }

    public static void main(String[] args) {
        System.out.println(ListNodeUtil.buildArray(new Solution2().reverseList(ListNodeUtil.buildLinkedList(new Integer[]{
                        1, 2, 3, 4, 5
                }))));
    }
}
