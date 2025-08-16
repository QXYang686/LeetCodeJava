package problem23;

import common.ListNode;
import common.ListNodeUtil;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 利用堆结构
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparing((ListNode n) -> n.val));
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }
        ListNode dummyHead = new ListNode(), tail = dummyHead;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (node.next != null) heap.offer(node.next);
            tail.next = node;
            tail = tail.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        System.out.println(ListNodeUtil.equals(ListNodeUtil.buildLinkedList(new Integer[]{1, 1, 2, 3, 4, 4, 5, 6}),
                new Solution1().mergeKLists(new ListNode[]{
                        ListNodeUtil.buildLinkedList(new Integer[]{1, 4, 5}),
                        ListNodeUtil.buildLinkedList(new Integer[]{1,3,4}),
                        ListNodeUtil.buildLinkedList(new Integer[]{2,6})
                })));
        System.out.println(ListNodeUtil.equals(ListNodeUtil.buildLinkedList(new Integer[]{}),
                new Solution1().mergeKLists(new ListNode[]{
                        ListNodeUtil.buildLinkedList(new Integer[]{})
                })));
    }
}
