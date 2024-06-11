package com.example.demo1.feignclient;

import com.example.common.dto.TbCommentDto;
import com.example.common.vo.TbQuestionVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * name：集群服务端名称
 * url：如果您指定了 url 属性，则 Feign 客户端不会使用 Ribbon 进行负载均衡。此时 Feign 客户端会直接使用指定的 URL。
 *
 */
@FeignClient(name = "${demo2_name}")
public interface TestFeignClient {

    @PostMapping("/questions/queryCommentList")
    List<TbCommentDto> queryCommentList(@RequestBody TbQuestionVo vo);

}
