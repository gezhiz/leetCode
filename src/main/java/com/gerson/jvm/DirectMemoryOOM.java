package com.gerson.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/**
 * @author gezz
 * @description
 * @date 2020/4/1.
 */
public class DirectMemoryOOM {

    public static final int _1MB = 1024 * 1024;

    /**
     *
     -Xmx5M -Xmx10M -XX:MaxDirectMemorySize=10M -verbose:gc -XX:+PrintGCDetails -XX:+DisableExplicitGC

     https://www.cnblogs.com/duanxz/p/6089485.html

     * 由于堆外内存并不直接控制于JVM，因此只能等到full GC的时候才能垃圾回收！
     * （direct buffer归属的的JAVA对象是在堆上且能够被GC回收的，
     * 一旦它被回收，JVM将释放direct buffer的堆外空间。前提是没有关闭DisableExplicitGC）
     *
     *
     * DisableExplicitGC 禁止显示调用GC
     * -XX:+DisableExplicitGC //增加此参数一会儿就会内存溢出java.lang.OutOfMemoryError: Direct buffer memory
     *
     * NIO直接内存的回收，需要依赖于System.gc()。如果我们的应用中使用了java nio中的direct memory，
     * 那么使用-XX:+DisableExplicitGC一定要小心，存在潜在的内存泄露风险。
     *
     * DirectByteBuffer 中的 java.nio.Bits 内部显示调用了System.gc()显示进行回收
     *
     * 堆内存由JVM自己管理，堆外内存必须要由我们自己释放；堆内存的消耗速度远远小于堆外内存的消耗，
     * 但要命的是必须先释放堆内存中的对象，才能释放堆外内存，但是我们又不能强制JVM释放堆内存。


     *
     * Exception in thread"main"java.lang.OutOfMemoryError
     at sun.misc.Unsafe.allocateMemory（Native Method）

     *
     * @param args
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
//        Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
//        unsafeField.setAccessible(true);
//        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
//            unsafe.allocateMemory(_1MB);
            ByteBuffer.allocateDirect(_1MB);
        }
    }
}
