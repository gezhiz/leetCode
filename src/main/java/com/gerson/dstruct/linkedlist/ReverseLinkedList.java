package com.gerson.dstruct.linkedlist;

import org.junit.Test;

/**
 * @author gezz
 * @description
 * @date 2020/5/22.
 */
public class ReverseLinkedList {

    @Test
    public void test() {
        ListNode head = ListNodeUtil.generateLinkedList1();
        head = reverse(head);
        ListNodeUtil.printListNode(head);
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return head;
    }

}
