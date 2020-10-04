package common;

public class ListNodeUtil {
    public static ListNode buildLinkedList(Integer[] values) {
        ListNode head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            head = new ListNode(values[i], head);
        }
        return head;
    }
}
