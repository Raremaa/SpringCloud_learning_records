package com.saiqima.eureka_client_zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description : Eureka整合Zuul微服务网关
 * 注意注解 @EnableZuulProxy 是声明一个Zuul代理
 * 该代理使用Ribbon来定位注册在Eureka Server中的微服务(自动实现负载均衡)
 * 该代理也整合了Hystrix,实现容错,所有经过Zuul的请求都会在Hystrix命令中执行(自动实现熔断)
 * @Author : saiqi.ma
 * @Date : 2019/6/18 16:55
 */
@EnableZuulProxy
@SpringBootApplication
public class EurekaClientZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientZuulApplication.class, args);
	}

}
