package com.example.common.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 富文本表
 */
@Data
public class TbEditorData implements Serializable {

    private Integer id;

    /**
     * html渲染数据
     */
    private String html;

    /**
     * 编辑器渲染数据
     */
    private String raw;

}
