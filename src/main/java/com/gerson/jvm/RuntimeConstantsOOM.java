package com.gerson.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量导致永久代OutOfMemory
 * @author gezz
 * @description
 * @date 2020/4/1.
 */
public class RuntimeConstantsOOM {


    /**
     * 在jdk1.6以前会出现
     * “Exception in thread"main"java.lang.OutOfMemoryError：PermGen space
     at java.lang.String.intern（Native Method）”


     * jdk 1.7以前可以使用
     *  -XX:PermSize=10M -XX:MaxPermSize=10M
     *
     *
     * jdk 1.8之后用
     * -XX:MetaspaceSize=5330K -XX:MaxMetaspaceSize=5330K
     *
     Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10M; support was removed in 8.0
     Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=10M; support was removed in 8.0
     * @param args
     */
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        while (true) {
            System.out.println(i);
            list.add(String.valueOf(i++).intern());
        }
    }

}
