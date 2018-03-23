package com.server.zuul.response;

import java.io.Serializable;
import java.util.List;

public class DockerStateResultResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Docker> dockers;
	
	public static class Docker implements Serializable{

		private static final long serialVersionUID = 1L;

		private String name;
		
		private String cpu;
		
		private String mem_limit;
		
		private String mem_percent;
		
		private String netio;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCpu() {
			return cpu;
		}

		public void setCpu(String cpu) {
			this.cpu = cpu;
		}

		public String getMem_limit() {
			return mem_limit;
		}

		public void setMem_limit(String mem_limit) {
			this.mem_limit = mem_limit;
		}

		public String getMem_percent() {
			return mem_percent;
		}

		public void setMem_percent(String mem_percent) {
			this.mem_percent = mem_percent;
		}

		public String getNetio() {
			return netio;
		}

		public void setNetio(String netio) {
			this.netio = netio;
		}
	}

	public List<Docker> getDockers() {
		return dockers;
	}

	public void setDockers(List<Docker> dockers) {
		this.dockers = dockers;
	}
	


}
