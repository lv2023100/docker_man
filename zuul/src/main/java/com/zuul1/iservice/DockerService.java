package com.zuul1.iservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.Param;
import feign.RequestLine;

@FeignClient(value = "server")
public interface DockerService {
	
	@RequestLine("GET /info")
    String hello(); 
	
	@RequestLine("GET /docker-state/{ip}")
    String dockerMan(@Param ("ip") String ip);
	


}
