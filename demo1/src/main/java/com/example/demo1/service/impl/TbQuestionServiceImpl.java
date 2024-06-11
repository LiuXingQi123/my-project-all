package com.example.demo1.service.impl;

import com.example.common.dto.TbCommentDto;
import com.example.common.dto.TbQuestionDto;
import com.example.common.vo.TbQuestionVo;
import com.example.demo1.dao.TbQuestionMapper;
import com.example.demo1.feignclient.TestFeignClient;
import com.example.demo1.service.TbQuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TbQuestionServiceImpl implements TbQuestionService {

    @Resource
    private TbQuestionMapper tbQuestionMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private TestFeignClient testFeignClient;

    public boolean setIfAbsentWithExpire(String key, String value, long expireSeconds) {
        // Lua 脚本，用于尝试设置一个键（只有当键不存在时才设置成功），并设置过期时间
        String script = "if redis.call('setnx', KEYS[1], ARGV[1]) == 1 then redis.call('expire', KEYS[1], ARGV[2]) return 1 else return 0 end";
        // 执行 Lua 脚本
        Long result = stringRedisTemplate.execute(
                new DefaultRedisScript<Long>(script, Long.class), // 指定脚本和返回类型
                Collections.singletonList(key), // KEYS参数，传递键名
                value, String.valueOf(expireSeconds) // ARGV参数，传递值和过期时间（秒）
        );
        // 返回结果，如果返回1表示设置成功（即键原本不存在），否则返回0（键已存在）
        return result != null && result == 1;
    }


    /**
     * 分页问题查询
     */
    @Override
    public PageInfo<TbQuestionDto> queryTitlePage(TbQuestionVo vo) {

        boolean bol = setIfAbsentWithExpire("setNxKey", "value", 10);

        if (!bol) {
            System.out.println("缓存被击穿了");
        } else {
            System.out.println("设置成功");
        }

        vo.setBeginNo((vo.getPageIndex() - 1) * vo.getPageSize());
        vo.setEndNo(vo.getPageSize());

        // 分页查询
        List<TbQuestionDto> questionList = tbQuestionMapper.queryTitlePage(vo);

        // 使用 PageHelper 进行分页查询
        PageHelper.startPage(vo.getPageIndex(), vo.getPageSize());

        // 将查询结果封装到 PageInfo 对象中
        PageInfo<TbQuestionDto> pageInfo = new PageInfo<>(questionList);

        // 获取总记录数
        int total = tbQuestionMapper.queryTitlePageCount(vo);
        pageInfo.setTotal(total);

        return pageInfo;
    }

    /**
     * 评论list
     * 并没有返回树状结构，想的是前端点击某一个评论展开才去查询对应的评论
     * ，而不是一次性把所有的评论一次性传给前端（这样当层级比较多的时候就会查询的特别慢，查询难度指数级上升）
     * ，正常是前端点击某一个评论，先是加载一部分评论，当前端点击显示更多的时候再去加载一部分评论
     */
    @Override
    public List<TbCommentDto> queryCommentList(TbQuestionVo vo) {
        List<TbCommentDto> list = testFeignClient.queryCommentList(vo);
        // List<TbCommentDto> list = tbQuestionMapper.queryCommentList(vo);
        return list;
    }

}
