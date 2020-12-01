package com.duing.service;

import com.duing.domain.Question;

public interface QuestionService {

    //查找下一题
    Question findNextOne(int index);

    //查找上一题
    Question findPreOne(int index);



    void setSelectedNumber(int selectedNumber);

    int getSelectedNumber();
}
