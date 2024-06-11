package com.example.common.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 问题标签关联表
 */
@Data
public class TbQuestionTag implements Serializable {

    /**
     * 标签ID
     */
    private Integer tagId;

    /**
     * 问题ID
     */
    private String questionId;

}
