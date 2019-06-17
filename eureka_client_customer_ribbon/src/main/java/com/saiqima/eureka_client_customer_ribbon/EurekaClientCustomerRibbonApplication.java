package com.saiqima.eureka_client_customer_ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description : Eureka Client 整合Ribbon的服务消费者
 * @Author : saiqi.ma
 * @Date : 2019/6/17 10:48
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientCustomerRibbonApplication {

	//LoadBalanced负载均衡注解
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientCustomerRibbonApplication.class, args);
	}

}
