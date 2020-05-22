package com.gerson.dstruct.linkedlist;

import org.junit.Test;

/**
 * @author gezz
 * @description
 * @date 2020/5/20.
 */
public class Palindromic {
    @Test
    public void test() {
        ListNode<String> head = ListNodeUtil.generateLinkedList1();
        System.out.println(isPalindromic(head));
    }

    public boolean isPalindromic(ListNode<String> head) {
        if (head == null || head.next == null) {
            return false;
        }
        //记录分割的头部
        ListNode<String> prev = null;
        //最终slow指针指向后半个列表的头部
        ListNode<String> slow = head;
        //最终fast指针指向尾部或者null
        ListNode<String> fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode<String> next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.next;
        }
        while(slow != null) {
            if (!slow.val.equalsIgnoreCase(prev.val)) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }



}
