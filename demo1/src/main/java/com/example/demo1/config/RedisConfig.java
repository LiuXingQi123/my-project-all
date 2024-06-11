package com.example.demo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 表明这是一个Spring配置类
 */
@Configuration
public class RedisConfig {

    /**
     * 使用集群配置创建并返回一个Lettuce连接工厂
     */
    // @Bean
    // public LettuceConnectionFactory redisConnectionFactory() {
    //     // 配置连接到 Redis 集群
    //     RedisClusterConfiguration clusterConfig = new RedisClusterConfiguration()
    //             // 添加集群节点1
    //             .clusterNode("127.0.0.1", 6379)
    //             // 添加集群节点2
    //             .clusterNode("127.0.0.2", 6379)
    //             // 添加集群节点3
    //             .clusterNode("127.0.0.3", 6379);
    //     // 使用集群配置创建并返回一个Lettuce连接工厂
    //     return new LettuceConnectionFactory(clusterConfig);
    // }

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    /**
     * 返回配置好的RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 设置Redis连接工厂
        template.setConnectionFactory(connectionFactory);
        // 设置键的序列化方式为字符串序列化
        template.setKeySerializer(new StringRedisSerializer());
        // 设置值的序列化方式为字符串序列化
        template.setValueSerializer(new StringRedisSerializer());
        // 返回配置好的RedisTemplate
        return template;
    }

    /**
     * 配置 StringRedisTemplate bean。
     *
     * StringRedisTemplate 是 RedisTemplate 的一个子类，使用字符串作为键和值的序列化器。
     * 它简化了对 Redis 键值对的操作，特别适用于字符串键值对的 Redis 操作。
     *
     * @param connectionFactory Redis 连接工厂，用于创建 Redis 连接。这里使用的是 Lettuce 连接工厂。
     * @return 配置好的 StringRedisTemplate 实例。
     */
    @Bean
    public StringRedisTemplate stringRedisTemplate(LettuceConnectionFactory connectionFactory) {
        // 创建 StringRedisTemplate 实例
        StringRedisTemplate template = new StringRedisTemplate();
        // 设置连接工厂，这里使用的是 LettuceConnectionFactory
        template.setConnectionFactory(connectionFactory);
        // 返回配置好的 StringRedisTemplate 实例
        return template;
    }


}
