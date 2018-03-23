package com.server.zuul.response;

import java.io.Serializable;
import java.util.List;

public class FileResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<String> ip;

	public List<String> getIp() {
		return ip;
	}

	public void setIp(List<String> ip) {
		this.ip = ip;
	}
}
