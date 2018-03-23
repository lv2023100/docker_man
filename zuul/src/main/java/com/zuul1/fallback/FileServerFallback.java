package com.zuul1.fallback;

import com.zuul1.iservice.FileServer;

public class FileServerFallback implements FileServer{

	@Override
	public String fileName() {
		// TODO Auto-generated method stub
		return "error";
	}

}
