package com.gerson.dstruct.linkedlist;

/**
 * @author gezz
 * @description
 * @date 2020/5/22.
 */
public class ListNodeUtil {


    public static ListNode generateLinkedList1() {
        ListNode head = new ListNode("L");
        head.next = new ListNode("e");
        head.next.next =  new ListNode("v");
        head.next.next.next =  new ListNode("1");
        head.next.next.next.next =  new ListNode("l");
        return head;
    }

    public static ListNode generateLinkedList0() {
        ListNode head = new ListNode("L");
        head.next = new ListNode("e");
        head.next.next =  new ListNode("v");
        head.next.next.next =  new ListNode("1");
        return head;
    }

    public static ListNode generateLinkedListCycle() {
        ListNode head = new ListNode("L");
        ListNode node = head.next = new ListNode("e");
        head.next.next =  new ListNode("v");
        head.next.next.next =  new ListNode("1");
        head.next.next.next.next =  new ListNode("l");
        head.next.next.next.next.next =  node;
        return head;
    }


    public static void printListNode(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

}
