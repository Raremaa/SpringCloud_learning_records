package com.saiqima.eureka_client_customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname : CostumeController
 * @Author : saiqi.ma
 * @Date : 2019/6/17 9:57
 */
@RestController
@RequestMapping("/customer")
public class CostumeController {

	protected static final Logger LOG = LoggerFactory.getLogger(CostumeController.class);
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/go")
	public Entity go(@RequestParam("requestStr") String requestStr) {
		LOG.info("服务消费者向服务提供者发起了请求,请求字符串为: " + requestStr);
		return this.restTemplate.getForObject("http://localhost:2005/provider/go/" + requestStr, Entity.class);
	}
}
