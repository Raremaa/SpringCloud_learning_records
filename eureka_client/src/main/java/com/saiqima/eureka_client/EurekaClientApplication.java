package com.saiqima.eureka_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Eureka client
 *
 * EdgWare之前的版本必需用@EnableEurekaClient或者@EnableDiscoveryClient注解
 * 才可以注册到Eureka server;之后的版本只要导入依赖就会自动注册到服务中心
 *
 * 如果不想注册到Eureka server 可以使用@EnableDiscoveryClient(autoRegister = false)注解
 * 方便本地调试
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

}
