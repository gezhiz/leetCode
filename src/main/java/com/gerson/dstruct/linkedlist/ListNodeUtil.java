package com.gerson.dstruct.linkedlist;

/**
 * @author gezz
 * @description
 * @date 2020/5/22.
 */
public class ListNodeUtil {

    public static ListNode<Integer> generateIntegerList0() {
        ListNode<Integer> head = new ListNode<Integer>(1);
        head.next = new ListNode<Integer>(2);
        head.next.next =  new ListNode<Integer>(3);
        head.next.next.next =  new ListNode<Integer>(4);
        head.next.next.next.next =  new ListNode<Integer>(5);
        return head;
    }

    public static ListNode<Integer> generateIntegerList1() {
        ListNode<Integer> head = new ListNode<Integer>(2);
        head.next = new ListNode<Integer>(2);
        head.next.next =  new ListNode<Integer>(5);
        head.next.next.next =  new ListNode<Integer>(5);
        head.next.next.next.next =  new ListNode<Integer>(5);
        return head;
    }


    public static ListNode<Integer> generateIntegerList2() {
        ListNode<Integer> head = new ListNode<Integer>(2);
        head.next = new ListNode<Integer>(2);
        head.next.next =  new ListNode<Integer>(5);
        head.next.next.next =  new ListNode<Integer>(5);
        head.next.next.next.next =  new ListNode<Integer>(5);
        head.next.next.next.next.next =  new ListNode<Integer>(10);
        return head;
    }

    public static ListNode<String> generateLinkedList1() {
        ListNode<String> head = new ListNode<String>("L");
        head.next = new ListNode<String>("e");
        head.next.next =  new ListNode<String>("v");
        head.next.next.next =  new ListNode<String>("1");
        head.next.next.next.next =  new ListNode<String>("l");
        return head;
    }

    public static ListNode<String> generateLinkedList0() {
        ListNode<String> head = new ListNode<String>("L");
        head.next = new ListNode<String>("e");
        head.next.next =  new ListNode<String>("v");
        head.next.next.next =  new ListNode<String>("1");
        return head;
    }

    public static ListNode<String> generateLinkedListCycle() {
        ListNode<String> head = new ListNode<String>("L");
        ListNode<String> node = head.next = new ListNode<String>("e");
        head.next.next =  new ListNode<String>("v");
        head.next.next.next =  new ListNode<String>("1");
        head.next.next.next.next =  new ListNode<String>("l");
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
