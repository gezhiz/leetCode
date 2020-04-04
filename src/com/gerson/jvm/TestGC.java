package com.gerson.jvm;

/**
 * @author gezz
 * @description
 * @date 2020/4/3.
 */
public class TestGC {

    private static int _1MB = 1 * 1024 * 1024;

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseParNewGC
     * 堆总大小20M，新生代10M，老年代10M，Eden区:Survivor = 8 : 1，Eden区8MB, From Survivor 1MB, To Survivor 1MB
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        byte[] b1, b2, b3, b4;
        b1 = new byte[2 * _1MB];
        b2 = new byte[2 * _1MB];
        b3 = new byte[2 * _1MB];
        //出现一次Minor GC
        //分配担保机制提前转移到老年代去，大对象直接进入了老年代
        b4 = new byte[4 * _1MB];
//        b4 = new byte[4 * _1MB];
        //老年代内存不足以分配，进行Full GC
//        b4 = new byte[4 * _1MB];
    }

    /**
     -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseParNewGC -XX:PretenureSizeThreshold=3145728
     未发生gc，大对象直接进入了老年代（tenured generation）
     Heap
     par new generation   total 9216K, used 7659K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
     eden space 8192K,  93% used [0x00000007bec00000, 0x00000007bf37aef8, 0x00000007bf400000)
     from space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
     to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
     tenured generation   total 10240K, used 4096K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
     the space 10240K,  40% used [0x00000007bf600000, 0x00000007bfa00010, 0x00000007bfa00200, 0x00000007c0000000)
     Metaspace       used 3146K, capacity 4494K, committed 4864K, reserved 1056768K
     class space    used 349K, capacity 386K, committed 512K, reserved 1048576K
     */

    /**
     *
     -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseParNewGC

     [GC (Allocation Failure) [ParNew: 7495K->440K(9216K), 0.0096143 secs] 7495K->6584K(19456K), 0.0096501 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
     Heap
     par new generation   total 9216K, used 4701K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
     eden space 8192K,  52% used [0x00000007bec00000, 0x00000007bf029140, 0x00000007bf400000)
     from space 1024K,  43% used [0x00000007bf500000, 0x00000007bf56e2c0, 0x00000007bf600000)
     to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
     tenured generation   total 10240K, used 6144K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
     the space 10240K,  60% used [0x00000007bf600000, 0x00000007bfc00030, 0x00000007bfc00200, 0x00000007c0000000)
     Metaspace       used 3134K, capacity 4494K, committed 4864K, reserved 1056768K
     class space    used 347K, capacity 386K, committed 512K, reserved 1048576K
     */

    /**

     [GC (Allocation Failure) --[PSYoungGen: 7495K->7495K(9216K)] 15687K->15695K(19456K), 0.0027637 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]

     Allocation Failure ：内存分配失败导致Minor GC
     PSYoungGen:Parallel Scavenge收集器新生代GC，
     7495K->7495K(9216K）回收前后新生代的内存大小
     15687K->15695K(19456K)GC前后java堆已使用的容量大小

     [Full GC (Ergonomics) [PSYoungGen: 7495K->2457K(9216K)] [ParOldGen: 8200K->8193K(10240K)] 15695K->10650K(19456K), [Metaspace: 3182K->3182K(1056768K)], 0.0101300 secs] [Times: user=0.02 sys=0.01, real=0.01 secs]
     Full GC:发生Full GC
     PSYoungGen：Parallel Scavenge收集器新生代GC，发生了stop the world


     [GC (Allocation Failure) --[PSYoungGen: 7495K->7495K(9216K)] 15687K->15695K(19456K), 0.0027637 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Ergonomics) [PSYoungGen: 7495K->2457K(9216K)] [ParOldGen: 8200K->8193K(10240K)] 15695K->10650K(19456K), [Metaspace: 3182K->3182K(1056768K)], 0.0101300 secs] [Times: user=0.02 sys=0.01, real=0.01 secs]
     Heap
     PSYoungGen      total 9216K, used 6717K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
     eden space 8192K, 81% used [0x00000007bf600000,0x00000007bfc8f560,0x00000007bfe00000)
     from space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
     to   space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
     ParOldGen       total 10240K, used 8193K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
     object space 10240K, 80% used [0x00000007bec00000,0x00000007bf400690,0x00000007bf600000)
     Metaspace       used 3211K, capacity 4494K, committed 4864K, reserved 1056768K
     class space    used 355K, capacity 386K, committed 512K, reserved 1048576K


     */
}
