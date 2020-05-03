package com.gerson.juc.lockfree;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author gezz
 * @description
 * @date 2020/5/3.
 */
public class FreeLockList<E> {

    private Object[] elements = new Object[10];

    private AtomicStampedReference<Descriptor> descriptor = new AtomicStampedReference<Descriptor>(new Descriptor(0), (int) System.nanoTime());

    private static class Descriptor {

        public Descriptor(int size) {
            this.size = size;
        }

        /**
         * 集合大小
         */
        private int size = 0;

        /**
         * 当前添加到哪个索引
         */
        private int index = 0;

        public int getSize() {
            return size;
        }

        public int getIndex() {
            return index;
        }
    }

    public E get(int index) {
        Object element = elements[index];
        return element != null ? (E)element : null;
    }

    public void add(E e) {
        Descriptor oldDes;
        Descriptor newDes;
        int oldStamp = 0;
        do {
            oldStamp = descriptor.getStamp();
            oldDes = descriptor.getReference();
            newDes = new Descriptor(oldDes.getSize() + 1);
        } while (!descriptor.compareAndSet(oldDes, newDes,oldStamp, (int)System.nanoTime()));
        elements[oldDes.size] = e;
    }

    public void set(int index, E e) {
        Descriptor oldDes;
        Descriptor newDes;
        int oldStamp = 0;
        do {
            oldStamp = descriptor.getStamp();
            oldDes = descriptor.getReference();
            newDes = new Descriptor(oldDes.getSize());
            if (index > oldDes.size -  1) {
                throw new ArrayIndexOutOfBoundsException();
            }
        } while (!descriptor.compareAndSet(oldDes, newDes,oldStamp, (int)System.nanoTime()));
        elements[index] = e;
    }

    public int size() {
        return descriptor.getReference().size;
    }

    public static void main(String[] args) throws InterruptedException {
        FreeLockList<Integer> freeLockList = new FreeLockList<Integer>();
        freeLockList.add(123);
        freeLockList.add(123);
        freeLockList.add(123);
        freeLockList.add(123);
        freeLockList.add(123);
        freeLockList.add(123);
        for (int i = 0; i < 10; i++) {
            System.out.println(freeLockList.get(i));
        }
    }
}
