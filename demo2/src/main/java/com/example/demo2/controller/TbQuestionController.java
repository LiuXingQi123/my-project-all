package com.example.demo2.controller;

import com.example.common.dto.TbCommentDto;
import com.example.common.dto.TbQuestionDto;
import com.example.common.vo.TbQuestionVo;
import com.example.demo2.service.TbQuestionService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@RefreshScope
public class TbQuestionController {

    @Resource
    private TbQuestionService tbQuestionService;

    @Value("${some.property}")
    private String someProperty;

    @GetMapping("/test")
    public String test() {
        return someProperty;
    }

    /**
     * 问题分页
     */
    @PostMapping("/queryTitlePage")
    public PageInfo<TbQuestionDto> queryTitlePage(@RequestBody TbQuestionVo vo) {
        return tbQuestionService.queryTitlePage(vo);
    }

    /**
     * 评论
     */
    @PostMapping("/queryCommentList")
    public List<TbCommentDto> queryCommentList(@RequestBody TbQuestionVo vo) {
        return tbQuestionService.queryCommentList(vo);
    }

}
