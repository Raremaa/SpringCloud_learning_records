package com.saiqima.eureka_client_customer_feign_hystrix;

import lombok.Builder;
import lombok.Data;

/**
 * @Classname : Entity
 * @Description : 实体类
 * @Author : saiqi.ma
 * @Date : 2019/6/17 9:39
 */
@Data
public class Entity {
	//应用名
	private String name;
	//端口
	private String port;
	//请求字符串
	private String requestStr;

	public Entity() {
	}

	public Entity(String name, String port, String requestStr) {
		this.name = name;
		this.port = port;
		this.requestStr = requestStr;
	}
}
