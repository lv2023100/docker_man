package com.zuul1.iservice;

import org.springframework.cloud.netflix.feign.FeignClient;

import feign.RequestLine;

@FeignClient(value = "file")
public interface FileServer {
	
	@RequestLine("GET /file-name")
	String fileName();

}
