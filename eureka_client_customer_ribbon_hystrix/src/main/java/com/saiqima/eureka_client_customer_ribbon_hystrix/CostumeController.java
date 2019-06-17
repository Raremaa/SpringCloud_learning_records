package com.saiqima.eureka_client_customer_ribbon_hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	//eureka-client-provider是虚拟主机名 当Ribbon和Eureka配合使用,会自动将虚拟主机名映射成微服务的网络地址
	/**
	 * 注意注解@HystrixCommand指定了一个与go()方法同参数和返回值的回退方法,可以通过commandProperties指定配置HystrixCommand
	 * 对于一些异常信息,不需要触发fallback的,可以让业务中的异常类继承HystrixBadRequestException类,这是一个特殊的异常,遇到该异常Hystrix不会触发回退
	 * 还有另一种方案,通过ignoreExceptions属性配置不想执行回退的异常类
	 * 例子:@HystrixCommand(fallbackMethod = "goFallback", ignoreExceptions = {XXXException.class, xxxException.class})
	 */
	@HystrixCommand(fallbackMethod = "goFallback")
	@GetMapping("/go")
	public Entity go(@RequestParam("requestStr") String requestStr) {
		LOG.info("服务消费者向服务提供者发起了请求,请求字符串为: " + requestStr);
		return this.restTemplate.getForObject("http://eureka-client-provider/provider/go/" + requestStr, Entity.class);
	}

	/**
	 * @Description : 打印当前选择节点
	 * @Author : saiqi.ma
	 * @Date : 2019/6/17 10:59
	 */
	@GetMapping("/logInstance")
	public void logInstance() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("eureka-client-provider");
		CostumeController.LOG.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
	}

	//可以加一个入参Throwable throwable查看异常信息
	public Entity goFallback(String requestStr, Throwable throwable) {
		LOG.info(throwable.toString());
		Entity entity = Entity.builder()
				.name("Hystrix熔断机制测试")
				.port("Hystrix熔断机制测试")
				.requestStr(requestStr).build();
		return entity;
	}
}
