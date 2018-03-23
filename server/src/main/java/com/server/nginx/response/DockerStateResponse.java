package com.server.nginx.response;

import java.io.Serializable;

public class DockerStateResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	
	private Stat stat;
	
	public static class Stat implements Serializable{

		private static final long serialVersionUID = 1L;
		
		private PrecpuStats precpu_stats;
		
		private CpuStats cpu_stats;
		
		private MemoryStats memory_stats;
		
		private Networks networks;
		
		public static class MemoryStats implements Serializable{

			private static final long serialVersionUID = 1L;
			
			private Long usage;
			
			private Long limit;

			public Long getUsage() {
				return usage;
			}

			public void setUsage(Long usage) {
				this.usage = usage;
			}

			public Long getLimit() {
				return limit;
			}

			public void setLimit(Long limit) {
				this.limit = limit;
			}
		}
		
		public static class Networks implements Serializable{

			private static final long serialVersionUID = 1L;
			
			private Eth0 eth0;

			public static class Eth0 implements Serializable{

				private static final long serialVersionUID = 1L;

				private Long rx_bytes;
				
				private Long tx_bytes;

				public Long getRx_bytes() {
					return rx_bytes;
				}

				public void setRx_bytes(Long rx_bytes) {
					this.rx_bytes = rx_bytes;
				}

				public Long getTx_bytes() {
					return tx_bytes;
				}

				public void setTx_bytes(Long tx_bytes) {
					this.tx_bytes = tx_bytes;
				}
				
			}

			public Eth0 getEth0() {
				return eth0;
			}

			public void setEth0(Eth0 eth0) {
				this.eth0 = eth0;
			}
			
		}
		
		public static class PrecpuStats implements Serializable{

			private static final long serialVersionUID = 1L;
			
			private CpuUsage cpu_usage;
			
			private Long system_cpu_usage;
			
			public static class CpuUsage implements Serializable{

				private static final long serialVersionUID = 1L;
				
				private Long total_usage;

				public Long getTotal_usage() {
					return total_usage;
				}

				public void setTotal_usage(Long total_usage) {
					this.total_usage = total_usage;
				}
				
			}

			public CpuUsage getCpu_usage() {
				return cpu_usage;
			}

			public void setCpu_usage(CpuUsage cpu_usage) {
				this.cpu_usage = cpu_usage;
			}

			public Long getSystem_cpu_usage() {
				return system_cpu_usage;
			}

			public void setSystem_cpu_usage(Long system_cpu_usage) {
				this.system_cpu_usage = system_cpu_usage;
			}
			
		}
		
		public static class CpuStats implements Serializable{

			private static final long serialVersionUID = 1L;
			
			private CpuUsage cpu_usage;
			
			private Long system_cpu_usage;
			
			public static class CpuUsage implements Serializable{

				private static final long serialVersionUID = 1L;
				
				private Long total_usage;

				public Long getTotal_usage() {
					return total_usage;
				}

				public void setTotal_usage(Long total_usage) {
					this.total_usage = total_usage;
				}
				
			}

			public CpuUsage getCpu_usage() {
				return cpu_usage;
			}

			public void setCpu_usage(CpuUsage cpu_usage) {
				this.cpu_usage = cpu_usage;
			}

			public Long getSystem_cpu_usage() {
				return system_cpu_usage;
			}

			public void setSystem_cpu_usage(Long system_cpu_usage) {
				this.system_cpu_usage = system_cpu_usage;
			}
			
		}

		public PrecpuStats getPrecpu_stats() {
			return precpu_stats;
		}

		public void setPrecpu_stats(PrecpuStats precpu_stats) {
			this.precpu_stats = precpu_stats;
		}

		public CpuStats getCpu_stats() {
			return cpu_stats;
		}

		public void setCpu_stats(CpuStats cpu_stats) {
			this.cpu_stats = cpu_stats;
		}

		public MemoryStats getMemory_stats() {
			return memory_stats;
		}

		public void setMemory_stats(MemoryStats memory_stats) {
			this.memory_stats = memory_stats;
		}

		public Networks getNetworks() {
			return networks;
		}

		public void setNetworks(Networks networks) {
			this.networks = networks;
		}
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Stat getStat() {
		return stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}

}
