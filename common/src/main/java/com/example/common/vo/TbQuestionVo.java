package com.example.common.vo;

import lombok.Data;

@Data
public class TbQuestionVo extends BaseFilter {

    private String title;

    private String questionId;

    private int replyId;
}
