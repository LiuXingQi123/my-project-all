package com.example.common.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户点赞问题表
 */
@Data
public class TbUserLikedQuestion implements Serializable {

    /**
     * 用户
     */
    private String username;

    /**
     * 问题id
     */
    private String questionId;

}
