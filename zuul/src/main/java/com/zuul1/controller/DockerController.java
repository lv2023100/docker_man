package com.zuul1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zuul1.iservice.DockerService;
import com.zuul1.iservice.FileServer;

@RefreshScope
@RestController 
public class DockerController {
	
	
	@Value("${profile}")
	private String helloConfig;
	
	
	@Autowired  
    DockerService dockerService;  
	
	@Autowired
	FileServer fileServer;
  
    @RequestMapping(value = "/hello")  
    public String helloCustomer() {  
         
        return dockerService.hello();  
    }
    
	@RequestMapping("/docker-state/{ip}")
    String dockerMan(@PathVariable("ip") String ip){
		System.out.println(ip);
		return dockerService.dockerMan(ip+".json");
	}
	
	@RequestMapping("/file-name")
    String fileName(){
		return fileServer.fileName();
	}


}
