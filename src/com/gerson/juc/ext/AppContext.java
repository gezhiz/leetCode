package com.gerson.juc.ext;

import java.util.HashMap;
import java.util.Map;

/**
 * 程序执行上下文
 * @author gezz
 * @description
 * @date 2020/4/23.
 */
public class AppContext {

    private Map<String,Object> cache;

    /**
     * 用同一个threadLocal对象能够获取针对不同线程的不同AppContext
     Thread 对象内部维护了一个ThreadLocal.ThreadLocalMap 对象的实例
     ThreadLocal对象的get方法实现：把threadLocal 对象作为key传给Thread对象的threadLocalMap的key，然后拿到数据
     ThreadLocal对象的put()方法实现：把threadLocal 对象作为key传给Thread对象的threadLocalMap的key，然后设置数据
     */
    private static final ThreadLocal<AppContext> threadLocal = new NameThreadLocal(AppContext.class.getCanonicalName() + " ThreadLocal");

    /**
     * 私有构造，不允许外部创建该类，一个线程只允许有一个该实例
     */
    private AppContext() {
        cache = new HashMap<>();
    }

    public static AppContext getInstance() {
        if (threadLocal.get() == null) {
            AppContext appContext =  new AppContext();
            threadLocal.set(appContext);
            return appContext;
        }
        return threadLocal.get();
    }

    public void destory() {
        threadLocal.remove();
    }

    public Object get(String key) {
        return cache.get(key);
    }

    public void put(String key, Object object) {
        cache.put(key, object);
    }
}
