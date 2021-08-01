//package com.example.testabc.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//public class NacosProviderController {
//	
////	@Autowired
////	private LoadBalancerClient loadBalancerClient;
//	@Autowired
//	private RestTemplate restTemplate;
//	
//	
//	@Value("${spring.application.name}")
//	private String appName;
//	
////	
////	@Value("{spring-url.nacos-user-service}")
////	private String serverURL;
////	
////	@GetMapping(value="/comms/{id}")
////	public String patment(@PathVariable("id") Long id) {
////		
////		return restTemplate.getForObject(serverURL+"/comms/",String.class);
////	}
//
//	
////	@Value("${service-url.nacos-user-service}")
////	private String serverURL;
////	
////	
//	
////	public String echo() {
////		String serviceId="nacos-provider";
////		
////		ServiceInstance instance =loadBalancerClient.choose(serviceId);
////		String url=String.format("http://%s:%s/echo/%s",instance.getHost(),instance.getPort(),appName);
////		return restTemplate.getForObject(url,String.class);
////	}
//	
////	@GetMapping(value="/echo/{massage}")
////	public String test(@PathVariable(value="massage")String massage) {
////		return "hello";
////	}
//}
