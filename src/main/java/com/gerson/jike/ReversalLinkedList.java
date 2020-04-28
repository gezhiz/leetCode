package com.gerson.jike;

import com.gerson.leetcode.structure.MyLinkedList;
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
        myLinkedList.reverse1();
        Iterator<Integer> iterator = myLinkedList.getIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
        System.out.println("链表长度:" + myLinkedList.getSize());

    }

    @Test
    public void testDoubleReversal() {
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
    @Test
    public void testDoubleReversal2() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.add(7);
        myLinkedList.add(8);
        myLinkedList.doubleReverse3();
        Iterator<Integer> iterator = myLinkedList.getIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
        System.out.println("链表长度:" + myLinkedList.getSize());

    }

    @Test
    public void testHasLoop2() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.add(7);
        myLinkedList.makeLoop(3);
        System.out.println(myLinkedList.hasLoop2());

    }

    @Test
    public void testHasLoop1() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.add(7);
        myLinkedList.makeLoop(5);
        System.out.println(myLinkedList.hasLoop1());

    }





}
