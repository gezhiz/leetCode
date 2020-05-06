package com.gerson.design.exception;

/**
 * 受检异常:强制使用者捕获并进行异常处理
 * @author gezz
 * @description
 * @date 2020/5/6.
 */
public class IdGenerationFailureException extends Exception {

    public IdGenerationFailureException() {
        super();
    }

    public IdGenerationFailureException(String s) {
        super(s);
    }
}
