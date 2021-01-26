package com.afei.service.impl;

import com.afei.mapper.LessonMapper;
import com.afei.pojo.entity.Lesson;
import com.afei.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService {


    @Autowired
    private LessonMapper lessonMapper;
    @Override
    public void insert(Lesson lesson) {

        lessonMapper.insert(lesson);
    }

    @Override
    public void update(Lesson lesson) {
        lessonMapper.update(lesson);
    }
}
