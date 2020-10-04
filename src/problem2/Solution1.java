package problem2;

import common.ListNode;
import common.ListNodeUtil;

import java.util.LinkedList;

public class Solution1 {
    private ListNode recursiveAdd(ListNode l1, ListNode l2, int up) {
        if (l1 == null && l2 == null && up == 0) return null;
        ListNode digit = new ListNode(up);
        digit.val += l1 != null ? l1.val : 0;
        digit.val += l2 != null ? l2.val : 0;
        digit.next = recursiveAdd(l1 == null ? null : l1.next, l2 == null ? null : l2.next, digit.val / 10);
        digit.val %= 10;
        return digit;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recursiveAdd(l1, l2, 0);
    }

    public static void main(String[] args) {
        ListNode l11 = ListNodeUtil.buildLinkedList(new Integer[]{2,4,3});
        ListNode l21 = ListNodeUtil.buildLinkedList(new Integer[]{5,6,4});
        ListNode res1 = new Solution1().addTwoNumbers(l11, l21); // 807
        ListNode l12 = ListNodeUtil.buildLinkedList(new Integer[]{9,9,9});
        ListNode l22 = ListNodeUtil.buildLinkedList(new Integer[]{9,9,9,9,9,9});
        ListNode res2 = new Solution1().addTwoNumbers(l12, l22); // 807
    }
}
