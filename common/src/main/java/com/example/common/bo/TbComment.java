package com.example.common.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论表
 */
@Data
public class TbComment implements Serializable {

    private Integer id;

    /**
     * 评论，关联tb_editor_data
     */
    private Integer comment;

    /**
     * 评论的question
     */
    private String questionId;

    /**
     * 回复的评论ID，为0则为问题的首评
     */
    private Integer replyId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建用户
     */
    private String createUser;

}
