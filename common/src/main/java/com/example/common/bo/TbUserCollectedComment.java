package com.example.common.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户收藏评论记录表
 */
@Data
public class TbUserCollectedComment implements Serializable {

    /**
     * 用户
     */
    private String username;

    /**
     * 评论ID
     */
    private Integer commentId;

}
