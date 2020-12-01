package com.duing.dao;

import com.duing.domain.Question;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao {

    @Select("select qid,title,answer,choices from question")
    List<Question> findAll();

    @Select("select count(qid) from question")
    Integer findNumber();

}
