package com.example.demo1.dao;

import com.example.common.dto.TbCommentDto;
import com.example.common.dto.TbQuestionDto;
import com.example.common.vo.TbQuestionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbQuestionMapper {

    /**
     * 查询标题页的题目数量
     * @param vo 查询参数对象
     * @return 标题页的题目数量
     */
    int queryTitlePageCount(TbQuestionVo vo);

    /**
     * 查询标题页的题目列表
     * @param vo 查询参数对象
     * @return 标题页的题目列表
     */
    List<TbQuestionDto> queryTitlePage(TbQuestionVo vo);

    /**
     * 查询评论列表
     * @param vo 查询参数对象
     * @return 评论列表
     */
    List<TbCommentDto> queryCommentList(TbQuestionVo vo);


}
