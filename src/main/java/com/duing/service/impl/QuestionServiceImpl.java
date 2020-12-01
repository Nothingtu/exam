package com.duing.service.impl;


import com.duing.dao.QuestionDao;
import com.duing.domain.Question;
import com.duing.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    //创建一个变量用来存储学生选择的题数
    private int  selectedNumber;

    public void setSelectedNumber(int selectedNumber) {
        this.selectedNumber = selectedNumber;
    }

    public int getSelectedNumber() {
        return selectedNumber;
    }

    //在这里创建一个集合 缓存已经找到的题目
    private Map<Integer, Question> selectedQuestionBox = new HashMap<Integer, Question>();

    //创建一个集合用来存储依次发送给页面的题目id
    List questionList = new ArrayList();


    //在进行操作前需要先查询出数据库里的题目的数量
    private int maxNumber;

    //为例提高底层的性能 避免频繁的对数据库进行操作 所以创建了一个缓存，用来存储全部的题目
    private List<Question> allQuestionBox = new ArrayList<>();

    //普通块 在创建对象时初始化maxNumber 并将从数据库里读取到的题目全部缓存到allQuestionBox
    {

    }


    //随机从缓存好的题库中挑选题目，并将题目存入selectedQuestionBox
    @Override
    public Question findNextOne(int index) {

        maxNumber = questionDao.findNumber();
        allQuestionBox = questionDao.findAll();

        //参数index是当前的题号
        //若index小于selectedQuestionBox.size(),证明是通过框跳选回去了之后，再按的下一个
        //以下代码暂时有问提 上一题后再按下一题有问题
        if(index < selectedQuestionBox.size()) return selectedQuestionBox.get(index + 1);


        //随机产生一个1~maxNumber之间的数值 左闭右开的区间
        Integer id = new Random().nextInt(maxNumber);
        Question question = allQuestionBox.get(id);
        //把要换回的题目id存储依赖 与list索引形成对应的关系
        questionList.add(question.getQid());
        selectedQuestionBox.put(questionList.size(),question);
        //此处设置页面即将展示的假id为questionList集合的索引
        question.setQid(questionList.size());
        return question;
    }

    @Override
    public Question findPreOne(int index) {

        //通过参数页面展示的题目序号，找到questionList找真实的题目id 进而找到题目
        //序号和questionList的索引刚好一一对应，即为相等
        return selectedQuestionBox.get(index - 1);
    }
}
