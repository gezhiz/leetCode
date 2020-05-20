package com.gerson.dstruct;

import java.util.List;

/**
 * @author gezz
 * @description
 * @date 2020/5/20.
 */
public class Palindromic {
    class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public boolean isPalindromic(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if (fast != null) {
            //针对奇数的情况，slow处于中间位置
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
