package problem234;

import common.ListNode;
import common.ListNodeUtil;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0, back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front++).equals(vals.get(back--))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().isPalindrome(ListNodeUtil.buildLinkedList(new Integer[]{1,2}))); // false
        System.out.println(new Solution1().isPalindrome(ListNodeUtil.buildLinkedList(new Integer[]{-129,-129}))); // true
        System.out.println(new Solution1().isPalindrome(ListNodeUtil.buildLinkedList(new Integer[]{1,2, 2, 1}))); // true
    }
}
