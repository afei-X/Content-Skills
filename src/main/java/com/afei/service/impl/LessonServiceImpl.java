package com.afei.service.impl;

import com.afei.mapper.LessonMapper;
import com.afei.pojo.entity.Lesson;
import com.afei.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LessonServiceImpl implements LessonService {


    @Autowired
    private LessonMapper lessonMapper;


    @Override
    @Transactional(propagation = Propagation.NESTED,rollbackFor = Exception.class)
    public void insert() {

        Lesson lesson = new Lesson();
        lesson.setName("语文");
        lesson.setScore(98);
        lessonMapper.insert(lesson);

        //int i=1/0;
    }

    @Override
    public void update(Lesson lesson) {
        lessonMapper.update(lesson);
    }
}
