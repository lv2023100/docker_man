package com.zuul1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableFeignClients
//@EnableCircuitBreaker
public class Zuul1Application {
	
	@LoadBalanced //开启负载均衡客户端  
    @Bean //注册一个具有容错功能的RestTemplate  
    RestTemplate restTemplate() {  
        return new RestTemplate();  
    } 

	public static void main(String[] args) {
		SpringApplication.run(Zuul1Application.class, args);
	}
}
