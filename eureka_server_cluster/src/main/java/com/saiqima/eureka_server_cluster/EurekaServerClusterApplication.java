package com.saiqima.eureka_server_cluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description : Eureka Server高可用集群
 * @Author : saiqi.ma
 * @Date : 2019/6/14 16:25
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerClusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerClusterApplication.class, args);
	}

}
