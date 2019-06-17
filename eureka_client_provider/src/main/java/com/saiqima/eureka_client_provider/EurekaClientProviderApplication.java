package com.saiqima.eureka_client_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description : Eureka Client 服务提供者
 * @Author : saiqi.ma
 * @Date : 2019/6/17 9:36
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientProviderApplication.class, args);
	}

}
