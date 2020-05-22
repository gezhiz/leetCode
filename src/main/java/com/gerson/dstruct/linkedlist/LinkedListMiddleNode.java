package com.gerson.dstruct.linkedlist;

import org.junit.Test;

/**
 * 求链表的中间节点
 * @author gezz
 * @description
 * @date 2020/5/22.
 */
public class LinkedListMiddleNode {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    @Test
    public void test() {
        ListNode middleNode0 = middleNode(ListNodeUtil.generateLinkedList0());
        System.out.println(middleNode0.val);

        ListNode middleNode1 = middleNode(ListNodeUtil.generateLinkedList1());
        System.out.println(middleNode1.val);
    }
}
