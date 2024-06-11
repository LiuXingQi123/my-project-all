package com.example.common.dto;

import lombok.Data;

/**
 * 问题DTO
 */
@Data
public class TbQuestionDto {

    /**
     * 问题id
     */
    private String questionId;

    /**
     * 提问标题
     */
    private String title;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 答案(关联tb_editor_data表),未回答为0
     */
    private String answer;

    /**
     * 内容
     */
    private String html;

    /**
     * 标签
     */
    private String labels;

    /**
     * 浏览数量
     */
    private int visitedCount;

    /**
     * 回复数量
     */
    private int commentCount;


}
