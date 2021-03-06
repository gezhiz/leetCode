package com.gerson.design.observable;

import com.google.common.annotations.Beta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author gezz
 * @description
 * @date 2020/5/26.
 */
@Retention(RetentionPolicy.RUNTIME)//注解一直保持在运行时
@Target(ElementType.METHOD)
@Beta
public @interface Subscribe {
}
