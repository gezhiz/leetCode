package com.gerson.design.proxy;

import java.lang.reflect.Method;

/**
 * @author gezz
 * @description
 * @date 2020/6/1.
 */
public class ProxyConfig {

    private final Object target;
    private final Method method;

    public ProxyConfig(Object target, Method method) {
        this.target = target;
        this.method = method;
    }

    public Object getTarget() {
        return target;
    }

    public Method getMethod() {
        return method;
    }
}
