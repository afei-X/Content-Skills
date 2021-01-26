package com.afei.mapper;

import com.afei.pojo.entity.Lesson;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LessonMapper {



    void insert(Lesson lesson);

    void update(Lesson lesson);

}
