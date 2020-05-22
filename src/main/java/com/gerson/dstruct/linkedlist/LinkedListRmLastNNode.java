package com.gerson.dstruct.linkedlist;

import org.junit.Test;

/**
 * 删除链表倒数第n个节点的
 * @author gezz
 * @description
 * @date 2020/5/22.
 */

public class LinkedListRmLastNNode {

    public ListNode removeLastN(ListNode head, int n) {
        ListNode fast = head;
        //用head和fast生成一个长度为n + 1的窗口
        int i = 0;
        for (; i < n; i++) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
        }
        if (i < n - 1) {
            //链表长度不足n - 1 个
            return head;
        }
        if (fast == null) {
            //链表长度刚好为n个，则删除头结点
            head = head.next;
            return head;
        }

        ListNode prev = head;
        while (fast.next != null) {
            fast = fast.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    @Test
    public void test() {
        ListNode<String> head = ListNodeUtil.generateLinkedList0();
        head = removeLastN(head, 4);
        ListNodeUtil.printListNode(head);
    }

}
