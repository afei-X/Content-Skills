package com.afei.pojo.entity;

import com.afei.pojo.Base;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: afei
 * @Description: Student
 * @date: 2021/1/26 2:05 下午
 * @version : 1.0
 */

@Data
public class Student extends Base {


    private String fieldName;


    private Integer age;

}

