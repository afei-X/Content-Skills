package com.afei.pojo.designPattern.oberver;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author gongxiangfei
 * @describe 自定义事件
 * @dataTime 2019-06-27 18：21:00
 */

public class FreeEvent  extends ApplicationEvent {


    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public FreeEvent(Object source) {
        super(source);
    }
}
