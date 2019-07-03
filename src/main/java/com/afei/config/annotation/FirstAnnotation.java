package com.afei.config.annotation;

import java.lang.annotation.*;

/**
 * @author gongxiangfei
 * @describe 自定义注解
 */
/*注解可以定义的位置*/
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.TYPE})
/*保留到什么时期 编译器/运行期*/
@Retention(RetentionPolicy.RUNTIME)
/*允许被继承*/
@Inherited
/*注解包含在Javadoc中*/
@Documented
public @interface FirstAnnotation {

     String id() ;

     String  name();

     String value() default "";

     int length() default 0;

     boolean add() default false;
}
