package problem21;

import common.ListNode;
import common.ListNodeUtil;

import java.util.List;

public class Solution1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(), head = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
                head = head.next;
            } else {
                head.next = list2;
                list2 = list2.next;
                head = head.next;
            }
        }
        if (list1 == null) head.next = list2;
        else if (list2 == null) head.next = list1;
        else throw new RuntimeException("unreachable");
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode case1 = new Solution1().mergeTwoLists(
                ListNodeUtil.buildLinkedList(new Integer[]{1, 2, 4}),
                ListNodeUtil.buildLinkedList(new Integer[]{1, 3, 4})
        );
        System.out.println(ListNodeUtil.equals(ListNodeUtil.buildLinkedList(new Integer[]{1, 1, 2, 3, 4, 4}), case1));
        ListNode case2 = new Solution1().mergeTwoLists(
                ListNodeUtil.buildLinkedList(new Integer[]{}),
                ListNodeUtil.buildLinkedList(new Integer[]{})
        );
        System.out.println(ListNodeUtil.equals(ListNodeUtil.buildLinkedList(new Integer[]{}), case2));
        ListNode case3 = new Solution1().mergeTwoLists(
                ListNodeUtil.buildLinkedList(new Integer[]{}),
                ListNodeUtil.buildLinkedList(new Integer[]{0})
        );
        System.out.println(ListNodeUtil.equals(ListNodeUtil.buildLinkedList(new Integer[]{0}), case3));
    }
}
