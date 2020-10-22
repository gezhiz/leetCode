package com.gerson.jvm;

/**
 * @author gezz
 * @description
 * @date 2020/4/3.
 */
public class TestGCHandlerPromotion {

    private static int _1MB = 1 * 1024 * 1024;

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseParNewGC
     * 堆总大小20M，新生代10M，老年代10M，Eden区:Survivor = 8 : 1，Eden区8MB, From Survivor 1MB, To Survivor 1MB
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        byte[] b1, b2, b3, b4, b5, b6, b7;
        b1 = new byte[2 * _1MB];
        b2 = new byte[2 * _1MB];
        b3 = new byte[2 * _1MB];
        b1 = null;
        b4 = new byte[2 * _1MB];
        b5 = new byte[2 * _1MB];
        b6 = new byte[2 * _1MB];
        b4 = null;
        b5 = null;
        b6 = null;

        b7 = new byte[2 * _1MB];


    }

    /**
     *
     [GC (Allocation Failure) [ParNew: 7495K->446K(9216K), 0.0065550 secs] 7495K->4542K(19456K), 0.0065894 secs] [Times: user=0.02 sys=0.01, real=0.00 secs]
     [GC (Allocation Failure) [ParNew: 6830K->579K(9216K), 0.0007955 secs] 10926K->4675K(19456K), 0.0008123 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     LargeTopHeap
     par new generation   total 9216K, used 2874K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
     eden space 8192K,  28% used [0x00000007bec00000, 0x00000007bee4aed0, 0x00000007bf400000)
     from space 1024K,  56% used [0x00000007bf400000, 0x00000007bf490f70, 0x00000007bf500000)
     to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
     tenured generation   total 10240K, used 4096K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
     the space 10240K,  40% used [0x00000007bf600000, 0x00000007bfa00020, 0x00000007bfa00200, 0x00000007c0000000)

     // 4096K 的内存通过担保进入了老年代

     Metaspace       used 3158K, capacity 4494K, committed 4864K, reserved 1056768K
     class space    used 350K, capacity 386K, committed 512K, reserved 1048576K
     */

}
