package com.example.demo3.dao;

import com.example.common.dto.TbCommentDto;
import com.example.common.dto.TbQuestionDto;
import com.example.common.vo.TbQuestionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbQuestionMapper {

    int queryTitlePageCount(TbQuestionVo vo);

    List<TbQuestionDto> queryTitlePage(TbQuestionVo vo);

    List<TbCommentDto> queryCommentList(TbQuestionVo vo);

}
