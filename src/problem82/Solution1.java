package problem82;

import common.ListNode;
import common.ListNodeUtil;

public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE, head);
        ListNode pre = dummyHead, p = head;
        while (p != null) {
            if (p.next == null) break;
            // 发现重复值,执行跳过操作
            if (p.val == p.next.val) {
                while (p.next != null && p.val == p.next.val) p = p.next;
                pre.next = p.next;
            }
            // 不存在重复值，继续遍历即可
            else {
                pre = p;
            }
            p = pre.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        System.out.println(ListNodeUtil.buildArray(new Solution1().deleteDuplicates(ListNodeUtil.buildLinkedList(new Integer[]{1, 2, 3, 3, 4, 4, 5})))); // 1,2,5
        System.out.println(ListNodeUtil.buildArray(new Solution1().deleteDuplicates(ListNodeUtil.buildLinkedList(new Integer[]{1, 1, 1, 2, 3})))); // 2,3
    }
}
