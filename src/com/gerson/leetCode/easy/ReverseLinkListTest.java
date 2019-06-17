package com.gerson.leetCode.easy;

import com.gerson.leetCode.structure.LinkList;
import org.junit.Test;

import java.util.Iterator;

/**
 * @author gezhizheng
 */
public class ReverseLinkListTest {
    @Test
    public void testReverse() {
        LinkList<Integer> linkList = new LinkList<>();
        for (int i = 1; i < 10; i++) {
            linkList.add(i);
        }
        linkList.reverse();
        Iterator<Integer> iterator = linkList.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
