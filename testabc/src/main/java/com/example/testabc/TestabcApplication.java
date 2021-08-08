package com.example.testabc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAuthorizationServer				//授權服務
@EnableCaching							//啟動radis
@EnableTransactionManagement 			// 交易
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
//可以使用註解
	//開啟Security驗證機制	//prePostEnabled 處理有回傳值的權限
//@EnableDiscoveryClient					//啟動微服務
//@EnableConfigurationProperties			//jwt
public class TestabcApplication {


	public static void main(String[] args) {
		SpringApplication.run(TestabcApplication.class, args);
		System.out.println("Start");
	}

}
