package com.afei.mapper;

import com.afei.pojo.entity.Student;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author gongxiangfei01Ø
 */
@Mapper
public interface StudentMapper {



    Student queryStudent(Integer id);

    void insert(Student student);

}
