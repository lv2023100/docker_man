package com.server.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.annotation.Resource;

import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

@RestController 
public class DockerController {
	
    @RequestMapping("/info")  
    public String testA() {  
        return "hello I am is service B"; 
    } 
    
    // 使用者的帳號
    private static final String user = "ubuntu";
    //主機的IP
    private static final String host = "ec2-18-219-20-8.us-east-2.compute.amazonaws.com";
    
    private static final String COMMAND ="sudo sh file_loop.sh";
    
    
    @Resource  
    private ResourceLoader resourceLoader;  
    

    @GetMapping("/file-name")  
    public String sshConnect() throws  JSchException, IOException{
        Channel channel = null;
        Session session = null;
        try{
        	//File file = new ClassPathResource("Eit24328949.pem").getFile();
        	//org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:Eit24328949.pem");

            //建立連線
            JSch jsch = new JSch();
            session = jsch.getSession(user, host, 22);
            //session.setPassword("Eit24328949");
            session.setConfig("StrictHostKeyChecking", "no"); //將主機密鑰自動加入 known_hosts
            jsch.addIdentity("/Eit24328949.pem");
            session.connect(10 * 1000);   //設定連線Timeout
            channel = session.openChannel("exec"); //建立一個 exec 模式的 Chanel

            //執行指令
            ((ChannelExec) channel).setCommand(COMMAND);
            channel.connect(); //Chanel啟動連接

            //取得執行結果
            try (BufferedReader br = new BufferedReader(new InputStreamReader(channel.getInputStream()))) {
                String line;
                line = br.readLine();
//                while ((line = br.readLine()) != null) {
//                	line = line;
//                }
                System.out.printf("%s%n", line);
                return line;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //中斷連線並關閉 seesion 物件
            channel.disconnect();
            session.disconnect();
        }
		return "error";


    }

}
