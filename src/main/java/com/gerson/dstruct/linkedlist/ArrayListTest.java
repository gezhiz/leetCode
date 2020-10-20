package com.gerson.dstruct.linkedlist;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author gezz
 * @description
 * @date 2020/6/29.
 */
public class ArrayListTest {

    @Test
    public void testCapacity() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        //由于9小于ArrayList内部的最小容量，所以不会触发扩容的操作
        arrayList.ensureCapacity(9);
        //此时，由于内部的数组长度是0，至少扩容1.5倍，1.5倍仍然是0，则选定11作为新的数组容量
        arrayList.ensureCapacity(11);
        //此时，内部数组长度11，至少扩容1.5倍（16），虽然是给11，但16 > 12,此时容量为16
        arrayList.ensureCapacity(12);

        //由于此时，数组内不存在任何元素，会将内部的数组设置空数组
        arrayList.trimToSize();

        arrayList.ensureCapacity(12);
        arrayList.add(10);
        arrayList.add(10);
        //此时数组有两个非空元素，trim后，数组容量大小变为2
        arrayList.trimToSize();

        //1、在来说说ensureCapacity()方法的作用，由于数组的默认最小容量是10，
        //2、插入第一个元素的时候会把初始化一个长度为10的数组，如果我们事先知道大致需要多少个元素，
        // 可以一次性进行扩容操作，这样能够避免多次扩容，提高性能。或者可以通过在初始化ArrayList的时候就给初始容量
        System.out.println(arrayList);
    }
}
