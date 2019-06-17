package com.saiqima.eureka_client_customer_feign_hystrix;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname : EntityFeignClient
 * @Description : Feign 接口 Feign本身是基于接口的
 * @Author : saiqi.ma
 * @Date : 2019/6/17 11:56
 */

/**
 * 注意注解@FeignClient 由于使用了Eureka,Ribbon会把注解值转化为Eureka服务注册表中的服务
 * 还可使用url指定请求url,例如@FeignClient(name=xxx,url=xxx)
 */
@FeignClient(name = "eureka-client-provider", fallback = FeignClientFallback.class)
public interface EntityFeignClient {

	@GetMapping("/provider/go/{requestStr}")
	Entity go(@PathVariable String requestStr);
}

@Component
class FeignClientFallback implements EntityFeignClient{
	@Override
	public Entity go(String requestStr) {
		Entity entity = new Entity("Hystrix熔断机制测试","Hystrix熔断机制测试", requestStr);
		return entity;
	}
}
