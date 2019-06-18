package com.afei.config.redis;

/**
 * Description
 *
 * @author thinkpad
 * @version 1.0
 * Date                 Author			Version     Description
 * ------------------------------------------------------------------
 * 2018-3-1--13:06     suyin             1.0      Version
 */

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface RSToken {
    /**
     * 添加防止重复提交token
     *
     * @return
     */
    boolean add() default false;

    /**
     * 删除token
     *
     * @return
     */
    boolean remove() default false;

    /**
     * 添加token时间
     *
     * @return
     */
    int timeout() default 1800;

}
