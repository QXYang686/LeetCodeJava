package problem206;

import common.ListNode;
import common.ListNodeUtil;

public class Solution1 {
    /**
     * 迭代法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            // 记住下一节点用于下次遍历
            ListNode tempNode = curr.next;
            // 将上一节点连接到当前节点后
            curr.next = prev;
            // 将当前节点设为下次的上一节点
            prev = curr;
            // 将下一节点设为下次的当前节点
            curr = tempNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(ListNodeUtil.buildArray(new Solution1().reverseList(ListNodeUtil.buildLinkedList(new Integer[]{
                        1, 2, 3, 4, 5
                }))));
    }
}
