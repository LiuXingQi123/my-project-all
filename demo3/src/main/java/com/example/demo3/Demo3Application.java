package com.example.demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * - @SpringBootApplication 是一个组合注解，包含以下三个注解：
 * 1. @SpringBootConfiguration: 标识这是一个 Spring Boot 配置类。
 * 2. @EnableAutoConfiguration: 启用 Spring Boot 的自动配置机制。
 * 3. @ComponentScan: 启用组件扫描，以便自动发现和注册 Spring 组件。
 */
@SpringBootApplication
/**
 * - @EnableDiscoveryClient 注解启用服务发现功能，使应用能够注册到服务发现组件（如 Netflix Eureka、Consul 或 Zookeeper）。
 * 这个注解主要用于 Spring Cloud 应用，以便服务可以发现和调用彼此。
 * 它使得服务能够被注册到服务注册中心，并且能够从注册中心获取其他服务的信息。
 */
@EnableDiscoveryClient
/**
 * - @EnableFeignClients 注解启用 Feign 客户端，使应用能够通过 Feign 声明式 HTTP 客户端来调用远程服务。
 * Feign 是一个声明式的 Web Service 客户端，简化了 HTTP API 的调用。
 * 使用这个注解时，需要在应用中定义 Feign 客户端接口，并标注 @FeignClient 注解。
 * Feign 会自动根据接口定义创建实现类，并将 HTTP 请求发送到配置的服务地址。
 */
@EnableFeignClients
public class Demo3Application {

    /**
     * LoadBalance 是 ribbon的负载均衡注解
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);
    }

}
