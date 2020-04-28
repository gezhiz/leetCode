package com.gerson.jvm;

/**
 * @author gezz
 * @description
 * @date 2020/4/1.
 */
public class StackOFE {

    /**
     * Exception in thread "main" java.lang.StackOverflowError
     at com.gerson.jvm.StackOFE$JavaVMStackSOF.stackLeak(StackOFE.java:17)

     */

    /**
     *  -Xss160K
     *  xss 表示每个线程 java虚拟机栈的大小，减小这个数（或者减小-Xmx的值）能创建更多的线程。
     * @param args
     */
    public static void main(String[] args) {
        new JavaVMStackSOF().stackLeak();
    }

    public static class JavaVMStackSOF {
        private int i = 0;
        public void stackLeak() {
            i++;
            stackLeak();
        }
    }

}
