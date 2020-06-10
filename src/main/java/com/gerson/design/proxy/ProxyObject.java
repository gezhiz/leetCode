package com.gerson.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 支持单接口、单方法的代理模式
 * @author gezz
 * @description
 * @date 2020/6/1.
 */
public class ProxyObject implements InvocationHandler {
    private Object target;
    private Method method;
    private Object proxy;

    public static ProxyObject getInstance(ProxyConfig invocation) throws NoSuchMethodException {
        ProxyObject proxyObject = new ProxyObject();
        proxyObject.target = invocation.getTarget();
        proxyObject.method = invocation.getMethod();
        proxyObject.proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader()
                , invocation.getTarget().getClass().getInterfaces(), proxyObject);
        return proxyObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("代理前置处理");
        Object ret = null;
        try {
            ret = method.invoke(target, args);
        } catch (Exception e) {
            System.out.println("代理异常处理");
            return ret;
        }
        System.out.println("代理前置处理");
        return ret;
    }

    public void invoke(Object[] args) {
        invoke(proxy, method, args);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        SourceObject sourceObject = new SourceObject("gezz");
        String[] params = {"age"};
        ProxyObject proxyObject = getInstance(
                new ProxyConfig(sourceObject, sourceObject.getClass().getDeclaredMethod("func", String.class)));
        proxyObject.invoke(params);

    }
}
