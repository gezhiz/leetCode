package com.gerson.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gezz
 * @description
 * @date 2020/4/1.
 */
public class HeapOOM {


    /**
     *
     java.lang.OutOfMemoryError: Java heap space
     Dumping heap to /opt/jvm/oom/java_pid2035.hprof ...
     Heap dump file created [27801162 bytes in 0.142 secs]
     Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     at java.util.Arrays.copyOf(Arrays.java:3210)
     at java.util.Arrays.copyOf(Arrays.java:3181)
     at java.util.ArrayList.grow(ArrayList.java:261)
     at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
     at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
     at java.util.ArrayList.add(ArrayList.java:458)
     at com.gerson.jvm.HeapOOM.main(HeapOOM.java:36)
     at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
     at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
     at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     at java.lang.reflect.Method.invoke(Method.java:498)
     at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)

     */

    /**
     * jvm 参数配置
     * -Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/opt/jvm/oom/ -XX:SurvivorRatio=8
     *
     * SurvivorRatio = 8     表示一个survivor : eden = 1 : 8     (from survivor |  to survivor)
     * @param args
     */
    public static void main(String[] args) {
        List<OomObject> objects = new ArrayList();
        while (true) {
            objects.add(new OomObject());
        }
    }

    public static class OomObject {

    }

}
