package leetcode.to300;

import leetcode.dependency.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * Subject: LinkedList
 * #Easy
 */
public class _206_ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
