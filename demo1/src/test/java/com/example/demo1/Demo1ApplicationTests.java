package com.example.demo1;

import com.example.common.dto.TbCommentDto;
import com.example.common.vo.TbQuestionVo;
import com.example.demo1.dao.TbQuestionMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Demo1ApplicationTests {

    @Resource
    private TbQuestionMapper tbQuestionMapper;

    @Test
    void contextLoads() {
        TbQuestionVo vo = new TbQuestionVo();
        vo.setQuestionId("0");
        vo.setReplyId(1);
        List<TbCommentDto> list = tbQuestionMapper.queryCommentList(vo);
        System.out.println(list.size());
    }

}
