package com.saiqima.eureka_client_customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description : Eureka Client 服务消费者
 * @Author : saiqi.ma
 * @Date : 2019/6/17 10:09
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientCustomerApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientCustomerApplication.class, args);
	}

}
