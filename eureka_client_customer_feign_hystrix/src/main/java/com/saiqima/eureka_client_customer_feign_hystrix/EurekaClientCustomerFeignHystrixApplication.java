package com.saiqima.eureka_client_customer_feign_hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description : Eureka Client 服务消费者 整合feign和Hystrix
 * SpringCloud默认为Feign整合了Hystrix,不需要额外导包,需加入相关配置就可以
 * @Author : saiqi.ma
 * @Date : 2019/6/17 16:35
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientCustomerFeignHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientCustomerFeignHystrixApplication.class, args);
	}

}
