package com.example.common.dto;

import lombok.Data;

/**
 * 评论DTO
 */
@Data
public class TbCommentDto {

    private int commentId;
    private String questionId;

    private int replyId;

    private String createUser;
    private String createTime;
    private String html;
    private String raw;

    /**
     * 点赞评论数量
     */
    private int likedCommentCount;

    /**
     * 回复评论数量
     */
    private int repliedCount;

}
