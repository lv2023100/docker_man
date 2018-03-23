package com.zuul1.fallback;

import com.zuul1.iservice.DockerService;

public class DockerServiceFallback implements DockerService {
	
	@Override  
    public String hello() {  
  
        return "request error";  
    }

	@Override
	public String dockerMan(String ip) {

		return "request error";
	}


}
