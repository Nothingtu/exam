package com.duing.domain;

import lombok.Data;

/**
 * 这个类是用来存储题目的相关信息的
 */

@Data
public class Question {
    private Integer qid;
    private String title;
    private String answer;
    private String choices;
}
