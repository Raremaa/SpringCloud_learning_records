package com.saiqima.eureka_client_customer_feign_hystrix;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * fallback = FeignClientFallback.class 不需要查看回退信息
 * fallbackFactory = FeignClientFallbackFactory.class 需要查看回退信息
 */
@FeignClient(name = "eureka-client-provider", fallbackFactory = FeignClientFallbackFactory.class)
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

/**
 * 当需要查看回退原因,就需要通过Fallback Factory进行查看
 * 方式是回退类实现FallbackFactory类
 */
@Component
class FeignClientFallbackFactory implements FallbackFactory<EntityFeignClient> {
	private static final Logger LOG = LoggerFactory.getLogger(FeignClientFallbackFactory.class);
	@Override
	public EntityFeignClient create(Throwable throwable) {
		return new EntityFeignClient() {
			@Override
			//日志最好放在各个fallback方法中
			public Entity go(String requestStr) {
				LOG.info(throwable.toString());
				return null;
			}
		};
	}
}

