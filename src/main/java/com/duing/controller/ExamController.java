package com.duing.controller;

import com.alibaba.fastjson.JSONObject;
import com.duing.domain.Question;
import com.duing.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExamController {

    @Autowired
    private QuestionService questionService;

    //设计一个变量用来存储在大题目数
    private int maxNumber;

    @RequestMapping("/exam")
    public String startExam(String number, Model model){
        maxNumber = Integer.parseInt(number);
        questionService.setSelectedNumber(maxNumber);
        model.addAttribute("question",questionService.findNextOne(1));
        return "exam";
    }

    @ResponseBody
    @RequestMapping("/pre")
    public Question pre(String currentNumber){
        return questionService.findPreOne(Integer.parseInt(currentNumber));
    }

    @ResponseBody
    @RequestMapping("/next")
    public Question next(String currentNumber, Model model){
        Question question = questionService.findNextOne(Integer.parseInt(currentNumber));
        //添加一个message信息 当message为0时表示返回的题目是此次测试的最后一题
        if(question.getQid() == maxNumber) model.addAttribute("message","提交试卷");
        return question;
    }

}
