package problem234;

import common.ListNode;
import common.ListNodeUtil;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        // 找到前半部分链表的为节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head, p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isPalindrome(ListNodeUtil.buildLinkedList(new Integer[]{1,2}))); // false
        System.out.println(new Solution2().isPalindrome(ListNodeUtil.buildLinkedList(new Integer[]{1,2, 2, 1}))); // true
    }
}
