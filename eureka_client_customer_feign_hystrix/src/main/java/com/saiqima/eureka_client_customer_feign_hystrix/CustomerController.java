package com.saiqima.eureka_client_customer_feign_hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname : CustomerController
 * @Author : saiqi.ma
 * @Date : 2019/6/17 13:44
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private EntityFeignClient feignClient;

	@GetMapping("/go")
	public Entity go(@RequestParam("requestStr") String requestStr) {
		return this.feignClient.go(requestStr);
	}

}
