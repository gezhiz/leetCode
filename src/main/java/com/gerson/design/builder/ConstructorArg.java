package com.gerson.design.builder;

import org.junit.Test;

/**
 * 建造者模式的使用
 * 解决的问题：
 * 1、构造参数太多
 * 2、构造参数之间存在依赖关系
 * 3、如果希望构造内部的参数是final类型，则可以使用构造器为参数赋值
 * @author gezz
 * @description
 * @date 2020/5/13.
 */

public class ConstructorArg {
    private final boolean isRef;
    private final Class type;
    private final Object arg;
    // TODO: 待完善...

    private ConstructorArg(Builder builder) {
        this.isRef = builder.isRef;
        this.type = builder.type;
        this.arg = builder.arg;
    }

    public static class Builder {
        private boolean isRef;
        private Class type;
        private Object arg;

        public ConstructorArg builder() {
            if (isRef == true) {
                if (!(arg instanceof String)) {
                    throw new IllegalArgumentException("when the param isRef is true, arg must be a String instance");
                }
            }
            if (isRef == false) {
                if (arg == null) {
                    throw new IllegalArgumentException("when the param isRef is false, arg can not be none");
                }
                if (type == null) {
                    throw new IllegalArgumentException("when the param isRef is false, type can not be none");
                }
            }
            return new ConstructorArg(this);
        }

        public boolean isRef() {
            return isRef;
        }

        public Builder setRef(boolean ref) {
            isRef = ref;
            return this;
        }

        public Class getType() {
            return type;
        }

        public Builder setType(Class type) {
            this.type = type;
            return this;
        }

        public Object getArg() {
            return arg;
        }

        public Builder setArg(Object arg) {
            this.arg = arg;
            return this;
        }
    }

    public boolean isRef() {
        return isRef;
    }

    public Class getType() {
        return type;
    }

    public Object getArg() {
        return arg;
    }


    public static class TestClass {

        @Test
        public void test() {
            ConstructorArg constructorArg = new ConstructorArg.Builder()
                    .setRef(false)
                    .setType(Integer.class)
                    .setArg(100)
                    .builder();
            Integer arg = (Integer) constructorArg.getArg();
            System.out.println(arg);
        }
    }
}
