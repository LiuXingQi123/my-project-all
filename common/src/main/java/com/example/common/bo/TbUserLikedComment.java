package com.example.common.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户点赞评论表
 */
@Data
public class TbUserLikedComment implements Serializable {

    /**
     * 用户
     */
    private String username;

    /**
     * 评论id
     */
    private Integer commentId;

}
