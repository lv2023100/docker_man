package com.server.connect;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ConnectAPI {
	
//	@Value("${docker.api.url}")
//	private String apiUrl;
	
	@Autowired
	private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
	
	@Autowired
	private ObjectMapper mapper;
	
	public <T> String getApi(String ip ,String uri) throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<Object>( null, headers);
        System.out.println("http://"+ip+":99/"+uri);
        RestTemplate template = new RestTemplate();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList( MediaType.TEXT_HTML,MediaType.APPLICATION_OCTET_STREAM));
        template.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        ResponseEntity<Object[]> respEntity = template.exchange( 
        		"http://"+ip+":99/"+uri, 
                HttpMethod.GET, 
                entity, 
                Object[].class,
                new HashMap<String, String>() );
        Object[] respVoCome = respEntity.getBody();       

        String json = mapper.writeValueAsString( respVoCome );
        return json;
	}

}
