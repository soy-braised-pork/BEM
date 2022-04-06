package com.example.demo.util;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(METHOD)
@Retention(RUNTIME)
public @interface Token {
    String value() default "token"; //获取入参中token默认key:token
    String keyPhone() default "";

}
