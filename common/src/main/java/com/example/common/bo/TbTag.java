package com.example.common.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 标签表
 */
@Data
public class TbTag implements Serializable {

    private Integer id;

    /**
     * 标签值
     */
    private String label;

    /**
     * 点击次数
     */
    private Integer count;

    /**
     * 分类
     */
    private String category;

}
