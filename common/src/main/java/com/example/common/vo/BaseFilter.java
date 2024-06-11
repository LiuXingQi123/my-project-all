package com.example.common.vo;

import lombok.Data;

@Data
public class BaseFilter {

    private int pageIndex;

    private int pageSize;

    private int beginNo;

    private int endNo;

}
