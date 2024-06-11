package com.example.common.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 问题表
 */
@Data
public class TbQuestion implements Serializable {

    private String id;

    /**
     * 提问标题
     */
    private String title;

    /**
     * 标签，多个逗号分隔
     */
    private String tags;

    /**
     * 问题(关联tb_editor_data表)
     */
    private Integer question;

    /**
     * 答案(关联tb_editor_data表),未回答为0
     */
    private Integer answer;

    /**
     * 状态：1.已上架 0已下架
     */
    private Integer status;

    /**
     * 问题回复人
     */
    private String answerer;

    /**
     * 是否精品
     */
    private Integer classic;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateUser;

    /**
     * update_time
     */
    private Date updateTime;

    /**
     * 是否删除，1为是，0为否
     */
    private Integer deleteFlag;

}
