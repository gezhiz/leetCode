package com.gerson.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法区出现的内存溢出
 * @author gezz
 * @description
 * @date 2020/4/1.
 */
public class JavaMethodAreaOOM {

    /**
     * Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
     at sun.misc.Unsafe.defineClass(Native Method)
     */

    /**
     * -XX:MetaspaceSize=5330K -XX:MaxMetaspaceSize=5330K
     * @param args
     */
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        while (true) {
            enhancer.setSuperclass(HeapOOM.OomObject.class);
            enhancer.setUseCache(true);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    if ("fun".equals(method.getName())) {
                        System.out.println("proxy: before execute fun");
                        String superResult = null;
                        try {
                            superResult = (String) proxy.invokeSuper(o, args);
                        } catch (Exception e) {
                            System.out.println("proxy: exception ！");
                        }
                        System.out.println("proxy: after execute fun");
                        return superResult;
                    }
                    return null;
                }
            });
            HeapOOM.OomObject oomObjectProxy = (HeapOOM.OomObject) enhancer.create();
            oomObjectProxy.fun("cglib proxy");
        }

    }
}
