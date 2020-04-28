package com.gerson.juc;

import com.gerson.juc.ext.AppContext;

/**
 * @author gezz
 * @description
 * @date 2020/4/23.
 */
public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {
        AppContext appContext =  AppContext.getInstance();
        AppContext appContext2 =  AppContext.getInstance();

        //true
        System.out.println(appContext == appContext2);
        appContext.destory();

        //false 调用了ThreadLocal的remove之后，再次获取AppContext之后，发现线程内部存放的AppContext对象已经发生了变化
        System.out.println(appContext == AppContext.getInstance());

        //而且，每次在线程把任务结束之后，必须要手动调用destory 调用destory之后，不允许再次使用

        for (int i = 0; i < 10; i++) {
            new MyThread("thread-" + i + "", () -> {
                new Filter1().exeTask("config", "value1");
                new Filter2().exeTask("config", "value2");
                new Filter1().exeTask("config", "value3");

            }).start();
        }
        Thread.sleep(1000);
    }

    public static class MyThread extends Thread {

        public MyThread(String name, Runnable runnable) {
            super(runnable);
            setName(name);
        }
    }
    /**
     * 演示多个类共享一个AppContext对象
     */
    interface Filter {
        void exeTask(String key, Object value);
    }

    public static class Filter1 implements Filter {

        @Override
        public void exeTask(String key, Object value) {
            AppContext appContext = AppContext.getInstance();
            System.out.println(Thread.currentThread().getName() + ":" + appContext.get(key));
            appContext.put(key,value);
        }
    }


    public static class Filter2 implements Filter {

        @Override
        public void exeTask(String key, Object value) {
            AppContext appContext = AppContext.getInstance();
            System.out.println(Thread.currentThread().getName() + ":" + appContext.get(key));
            appContext.put(key,value);
        }
    }

}
