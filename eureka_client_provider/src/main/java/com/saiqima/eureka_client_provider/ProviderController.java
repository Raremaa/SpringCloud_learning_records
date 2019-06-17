package com.saiqima.eureka_client_provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname : ProviderController
 * @Description : 服务提供者控制层
 * @Author : saiqi.ma
 * @Date : 2019/6/17 9:37
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

	protected static final Logger LOG = LoggerFactory.getLogger(ProviderController.class);

	@Value("${spring.application.name}")
	private String name;
	//端口
	@Value("${server.port}")
	private String port;

	/**
	 * 注意@PathVariable这个注解,Spring 3.0+新特性,用于接收请求路径中占位符的值,变量名不一样时需提供给注解参数
	 *
	 */
	@GetMapping("/go/{requestStr}")
	public Entity go(@PathVariable String requestStr) {
		LOG.info("服务消费者向服务提供者发起了请求,请求字符串为: " + requestStr);
		Entity entity = Entity.builder()
				.name(name)
				.port(port)
				.requestStr(requestStr).build();
		return entity;
	}
}
