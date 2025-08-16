package problem23;

import common.ListNode;
import common.ListNodeUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 分治法合并
        ArrayList<ListNode> toMergeList = new ArrayList<>();
        for (ListNode list : lists) {
            if (list != null) {
                toMergeList.add(list);
            }
        }
        while (toMergeList.size() > 1) {
            ArrayList<ListNode> nextToMergeList = new ArrayList<>();
            for (int i = 0; i < toMergeList.size(); i += 2) {
                ListNode left = i >= toMergeList.size() ? null : toMergeList.get(i);
                ListNode right = i + 1 >= toMergeList.size() ? null : toMergeList.get(i + 1);
                ListNode dummy = new ListNode(), tail = dummy;
                while (left != null || right != null) {
                    if (left == null) {
                        tail.next = right;
                        right = null;
                    }
                    else if (right == null) {
                        tail.next = left;
                        left = null;
                    }
                    else if (left.val < right.val) {
                        tail.next = left;
                        left = left.next;
                        tail = tail.next;
                    } else {
                        tail.next = right;
                        right = right.next;
                        tail = tail.next;
                    }
                }
                nextToMergeList.add(dummy.next);
            }
            toMergeList = nextToMergeList;
        }
        return toMergeList.isEmpty() ? null : toMergeList.get(0);
    }

    public static void main(String[] args) {
        System.out.println(ListNodeUtil.equals(ListNodeUtil.buildLinkedList(new Integer[]{1, 1, 2, 3, 4, 4, 5, 6}),
                new Solution2().mergeKLists(new ListNode[]{
                        ListNodeUtil.buildLinkedList(new Integer[]{1, 4, 5}),
                        ListNodeUtil.buildLinkedList(new Integer[]{1,3,4}),
                        ListNodeUtil.buildLinkedList(new Integer[]{2,6})
                })));
        System.out.println(ListNodeUtil.equals(ListNodeUtil.buildLinkedList(new Integer[]{}),
                new Solution2().mergeKLists(new ListNode[]{
                        ListNodeUtil.buildLinkedList(new Integer[]{})
                })));
    }
}
