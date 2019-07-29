package com.gerson.design.template;

import java.lang.reflect.UndeclaredThrowableException;

/**
 * @author gezz
 * @description 模板方法设计模式,事务管理的模板方法
 * @date 2019/7/29.
 */
public class TransactionTemplate {

    public <T> T execute(Executor<T> executor) {
        T result;
        System.out.println("开启事务");
        try {
            result = executor.execute();
        } catch (RuntimeException | Error ex) {
            System.out.println("回滚事务");
            throw ex;
        } catch (Throwable ex) {
            System.out.println("回滚事务");
            throw new UndeclaredThrowableException(ex, "事务回滚，抛出未处理的异常");
        }
        System.out.println("提交事务");
        return result;
    }

}
