package com.gerson.dstruct.linkedlist;

import org.junit.Test;

/**
 * 使用快慢指针判断链表是否存在环
 * @author gezz
 * @description
 * @date 2020/5/22.
 */
public class LinkedListCycle {

    public boolean containCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(containCycle(ListNodeUtil.generateLinkedList1()));
        System.out.println(containCycle(ListNodeUtil.generateLinkedListCycle()));
    }

}
