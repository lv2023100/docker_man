package com.container.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.container.connect.ConnectAPI;
import com.container.docker.response.Test;
import com.container.zuul.response.InspectResultResponse;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController 
public class InspectController {
	
	@Autowired
	private ConnectAPI connectAPI;
	
	@Autowired
	private ObjectMapper mapper;
	
    @GetMapping("/inspect/{ip}/{name}")  
    public InspectResultResponse inspect(@PathVariable ("ip") String ip, @PathVariable ("name") String name) {  
    	InspectResultResponse inspect = new InspectResultResponse();
    	try {
    		
    		String json = connectAPI.getApi( ip, "/containers/"+name+"/json");
    		String lowerJson = json.toLowerCase();
    		inspect = mapper.readValue(lowerJson, InspectResultResponse.class);
			System.out.println(inspect.getCreated());
			return inspect;
		} catch (Exception e) {

			e.printStackTrace();
			return inspect;
		}
    	
    }

}
