package com.afei.config.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Cache {



    @Autowired
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.selectList("select * from user ");

    }


}
