package com.example.demo3.service;

import com.example.common.dto.TbCommentDto;
import com.example.common.dto.TbQuestionDto;
import com.example.common.vo.TbQuestionVo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TbQuestionService {

    PageInfo<TbQuestionDto> queryTitlePage(TbQuestionVo vo);

    List<TbCommentDto> queryCommentList(TbQuestionVo vo);

}
