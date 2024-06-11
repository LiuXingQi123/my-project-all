package com.example.demo2.feignclient;

import com.example.common.dto.TbCommentDto;
import com.example.common.vo.TbQuestionVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "${demo1_name}", url = "${demo1_url}")
public interface TestFeignClient {

    @PostMapping("/questions/queryCommentList")
    List<TbCommentDto> queryCommentList(@RequestBody TbQuestionVo vo);

}
