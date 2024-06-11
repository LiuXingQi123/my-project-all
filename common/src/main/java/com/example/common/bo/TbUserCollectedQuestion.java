package com.example.common.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户收藏问题记录表
 */
@Data
public class TbUserCollectedQuestion implements Serializable {

    /**
     * 用户
     */
    private String username;

    /**
     * 问题ID
     */
    private String questionId;

    /**
     * create_time
     */
    private Date createTime;

}
