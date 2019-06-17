package com.saiqima.eureka_client_customer_ribbon;

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
}
