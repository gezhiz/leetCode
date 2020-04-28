package com.gerson.jvm;

/**
 *
 * @author gezz
 * @description
 * @date 2020/4/7.
 */
public class DynamicDispatch {
    static class Human {
        public void sayHello(){
            System.out.println("Human say hello");
        }

    }

    static class Man extends Human {

        @Override
        public void sayHello() {
            System.out.println("Man say Hello");
        }
    }

    static class Woman extends Human {

        @Override
        public void sayHello() {
            System.out.println("woman say Hello");
        }
    }

    static class Boy extends Man {

        @Override
        public void sayHello() {
            System.out.println("boy say Hello");
        }
    }

    /**
     *
     * 类加载阶段，man和woman两个引用类型再，无法唯一确定其数据类型，所以不能进行静态分派的方式确定类型，只能使用动态分派（invokevirtual）
     Man say Hello
     woman say Hello
     boy say Hello
     * @param args
     */
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        //virtual dispatch
        Man boy = new Boy();
        man.sayHello();
        woman.sayHello();
        boy.sayHello();
    }
}
