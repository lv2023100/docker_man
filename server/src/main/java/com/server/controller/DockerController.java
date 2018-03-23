package com.server.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.connect.ConnectAPI;
import com.server.nginx.response.DockerStateResponse;
import com.server.nginx.response.DockerStateResponse.Stat;
import com.server.util.UnitConversion;
import com.server.zuul.response.DockerStateResultResponse;
import com.server.zuul.response.DockerStateResultResponse.Docker;

@RestController 
public class DockerController {
	
	@Autowired
	private ConnectAPI connectAPI;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Value("${ip-address}")
	private String ipAddress;

    @RequestMapping("/info")  
    public String testA() {  
        return "hello I am is service A"; 
    } 
    
    @RequestMapping("ipaddress")
    public String ip(){
    	return ipAddress;
    }
    
    
    @GetMapping("/docker-state/{ip}")  
    public DockerStateResultResponse dockerState(@PathVariable ("ip") String ip) {  
    	DockerStateResultResponse dockerStateResultResponse = new DockerStateResultResponse();
    	List<DockerStateResultResponse.Docker> dockersList = new ArrayList<>();
        try {
        	String json = connectAPI.getApi(ip,"ip/"+ip);
        	List<DockerStateResponse> stateList = mapper.readValue(json, new TypeReference<List<DockerStateResponse>>(){}); 	
        	for(DockerStateResponse dockerStateResponse : stateList){
        		Docker docker = new Docker();
        		docker.setName(dockerStateResponse.getName());
        		Stat stat= dockerStateResponse.getStat();
        		System.out.println(dockerStateResponse.getName());
        		//cpu_percent
        		if(stat.getCpu_stats().getSystem_cpu_usage() == null){
        			stat.getCpu_stats().setSystem_cpu_usage(0L);
        		}
        		if(stat.getPrecpu_stats().getSystem_cpu_usage() == null){
        			stat.getPrecpu_stats().setSystem_cpu_usage(0L);
        		}
        		Long cpu_delta= stat.getCpu_stats().getCpu_usage().getTotal_usage()-stat.getPrecpu_stats().getCpu_usage().getTotal_usage();
        		Long system_delta = stat.getCpu_stats().getSystem_cpu_usage()-stat.getPrecpu_stats().getSystem_cpu_usage();
        		BigDecimal cpu=new BigDecimal(0);
        		if(cpu_delta!=0){
        			cpu= new BigDecimal(cpu_delta).divide(new BigDecimal(system_delta),5,BigDecimal.ROUND_HALF_UP);
        			cpu = cpu.multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
        		}
        		docker.setCpu(cpu.toString()+"%");
        		//mem_limit
        		if(stat.getMemory_stats().getUsage() == null){
        			stat.getMemory_stats().setUsage(0L);
        		}
        		if(stat.getMemory_stats().getLimit() == null){
        			stat.getMemory_stats().setLimit(0L);
        		}
        		BigDecimal memUsageBytes = new BigDecimal(stat.getMemory_stats().getUsage());
        		BigDecimal memLimitBytes = new BigDecimal(stat.getMemory_stats().getLimit());
        		String memUsage= UnitConversion.conversionKBAndMB(memUsageBytes);
        		String memLimit= UnitConversion.conversionKBAndMB(memLimitBytes);
        		docker.setMem_limit(memUsage+"/"+memLimit);
        		
        		//mem_percent
        		if(stat.getMemory_stats().getLimit() == 0){
            		docker.setMem_percent("0%");
        		}else{
        			BigDecimal memPercent = memUsageBytes.divide(memLimitBytes,5,BigDecimal.ROUND_HALF_UP);
        			memPercent = memPercent.multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
            		docker.setMem_percent(memPercent.toString()+"%");
        		}

        		
        		//netio
        		if(stat.getNetworks() == null){
        			docker.setNetio("0KB/0KB");
        		}else{
            		String rx= UnitConversion.conversionKBAndMB(new BigDecimal(stat.getNetworks().getEth0().getRx_bytes()));
            		String tx= UnitConversion.conversionKBAndMB(new BigDecimal(stat.getNetworks().getEth0().getTx_bytes()));
            		docker.setNetio(rx+"/"+tx);
        		}

        		
        		//set result
        		dockersList.add(docker);
        	}
        	dockerStateResultResponse.setDockers(dockersList);
        	return dockerStateResultResponse;
		} catch (Exception e) {
			
			e.printStackTrace();
			return dockerStateResultResponse;
		} 
    } 
}
