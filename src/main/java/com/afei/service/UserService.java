package com.afei.service;

/**
 * @author afei
 *
 *
 * 实例的接口
 */
public interface UserService {

    /**
     * 根据id获取名字
     * @param id
     * @return
     */
    String getName(int id);

    /**
     * 根据id获取年龄
     * @param id
     * @return
     */
    Integer getAge(int id);
}
