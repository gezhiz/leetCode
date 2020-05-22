package com.gerson.dstruct.linkedlist;

import org.junit.Test;

/**
 * 合并两个有序链表
 * @author gezz
 * @description
 * @date 2020/5/22.
 */
public class MergeLinkedList {

    @Test
    public void test() {
        ListNode<Integer> mergedLinkedList = merge(ListNodeUtil.generateIntegerList0(),ListNodeUtil.generateIntegerList2());
        ListNode<Integer> mergedLinkedList2 = mergeTwoLists(ListNodeUtil.generateIntegerList0(),ListNodeUtil.generateIntegerList2());
        ListNodeUtil.printListNode(mergedLinkedList);
        ListNodeUtil.printListNode(mergedLinkedList2);
    }

    public ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        //利用哨兵结点简化实现难度 技巧三
        ListNode<Integer> soldier = new ListNode<Integer>(0);
        ListNode<Integer> p = soldier;

        while ( l1 != null && l2 != null ){
            if ( l1.val < l2.val ){
                p.next = l1;
                l1 = l1.next;
            }
            else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) { p.next = l1; }
        if (l2 != null) { p.next = l2; }
        return soldier.next;
    }


    //复杂方式
    public ListNode<Integer> merge(ListNode<Integer> list1, ListNode<Integer> list2) {
        //利用哨兵节点
        ListNode<Integer> head = new ListNode<>(null);
        ListNode<Integer> tail = head;
        ListNode<Integer> c1 = list1;
        ListNode<Integer> c10 = null;
        ListNode<Integer> c2 = list2;
        ListNode<Integer> c20 = null;
        while (list1 != null || list2 != null) {
            if (c1 == null) {
                tail.next = c2;
                break;
            }
            if (c2 == null) {
                tail.next = c1;
                break;
            }
            if (c1.val <= c2.val) {
                while (c1 != null && c1.val <= (c2 == null ? c1.val : c2.val)) {
                    c10 = c1;
                    c1 = c1.next;
                }
                c10.next = null;
                tail.next = list1;
                tail = c10;
                list1 = c1;
            } else {
                while (c2 != null && c2.val <= (c1 == null ? c2.val : c1.val)) {
                    c20 = c2;
                    c2 = c2.next;
                }
                c20.next = null;
                tail.next = list2;
                tail = c20;
                list2 = c2;
            }
        }
        head = head.next;
        return head;
    }


}
