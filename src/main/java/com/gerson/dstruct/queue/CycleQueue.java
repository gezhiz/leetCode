package com.gerson.dstruct.queue;

/**
 * 使用数组实现循环队列，这样，避免了非循环队列的数据迁移问题
 * @author gezz
 * @description
 * @date 2020/5/25.
 */
public class CycleQueue {
    private String[] items;
    private int n = 0;

    private int tail = 0;
    private int head = 0;

    public static void main(String[] args) {
        CycleQueue cycleQueue = new CycleQueue(10);
        cycleQueue.enqueue("a");
        cycleQueue.enqueue("b");
        cycleQueue.enqueue("c");
        cycleQueue.enqueue("d");
        cycleQueue.enqueue("e");
        cycleQueue.enqueue("f");
        cycleQueue.enqueue("g");
        cycleQueue.enqueue("h");
        cycleQueue.enqueue("i");
        cycleQueue.enqueue("j");
        for (int i = 0; i < 10; i++) {
            System.out.println(cycleQueue.dequeue());
        }
    }

    public CycleQueue(int capacity) {
        this.n = capacity + 1;
        this.items = new String[n];
    }

    public boolean enqueue(String item) {
        if ((tail + 1) % n == head) {
            //队列已经满了
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    public int size() {
        return n - 1;
    }
}
