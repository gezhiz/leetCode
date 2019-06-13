package com.gerson.leetCode.easy;

import com.gerson.leetCode.structure.MyLinkedList;
import org.junit.Test;

import java.util.Iterator;

/**
 * 反转链表
 * Created by gezz on 2019/6/6.
 */
public class ReversalLinkedList {

    @Test
    public void testrReversal() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.add(7);
        myLinkedList.add(8);
        myLinkedList.reverse();
        Iterator<Integer> iterator = myLinkedList.getIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
        System.out.println("链表长度:" + myLinkedList.getSize());

    }

    @Test
    public void testrDoubleReversal() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.add(7);
        myLinkedList.doubleReverse();
        Iterator<Integer> iterator = myLinkedList.getIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
        System.out.println("链表长度:" + myLinkedList.getSize());

    }


}
