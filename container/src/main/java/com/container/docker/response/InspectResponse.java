package com.container.docker.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InspectResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String created;
	
	private String driver;
	
	private String platform;
	
	private State state;
	
	private Config config;
	
	private NetworkSettings networkSettings;
	
	public static class State implements Serializable{

		private static final long serialVersionUID = 1L;
		
		private String status;
		
		private Integer pid;
		
		private String starteAt;
		
		private String finishedAt;

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Integer getPid() {
			return pid;
		}

		public void setPid(Integer pid) {
			this.pid = pid;
		}

		public String getStarteAt() {
			return starteAt;
		}

		public void setStarteAt(String starteAt) {
			this.starteAt = starteAt;
		}

		public String getFinishedAt() {
			return finishedAt;
		}

		public void setFinishedAt(String finishedAt) {
			this.finishedAt = finishedAt;
		}
		
	}
	
	public static class Config implements Serializable{

		private static final long serialVersionUID = 1L;
		
		private List<String> env;
		
		private String image;
		
		private List<String> entrypoint;

		public List<String> getEnv() {
			return env;
		}

		public void setEnv(List<String> env) {
			this.env = env;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public List<String> getEntrypoint() {
			return entrypoint;
		}

		public void setEntrypoint(List<String> entrypoint) {
			this.entrypoint = entrypoint;
		}
		
	}
	
	public static class NetworkSettings implements Serializable{

		private static final long serialVersionUID = 1L;
		
		private List<String> env;
		
		private String image;
		
		private List<String> entrypoint;

		public List<String> getEnv() {
			return env;
		}

		public void setEnv(List<String> env) {
			this.env = env;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public List<String> getEntrypoint() {
			return entrypoint;
		}

		public void setEntrypoint(List<String> entrypoint) {
			this.entrypoint = entrypoint;
		}
		
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public NetworkSettings getNetworkSettings() {
		return networkSettings;
	}

	public void setNetworkSettings(NetworkSettings networkSettings) {
		this.networkSettings = networkSettings;
	}

}
