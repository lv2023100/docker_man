package com.zuul1.iservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

@Configuration
public class FeignConfiguration {
	
	  @Bean
	  public Contract feignContract() {
	    return new feign.Contract.Default();
	  }

}
