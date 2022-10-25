package com.bnmap;

import com.google.gson.annotations.Expose; 
import com.google.gson.annotations.SerializedName;


public class ScriptProperties {

	@SerializedName("name")
	@Expose
	private String name; 
	@SerializedName("IP")
	@Expose
	private String IP;
	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("number_packets_per_port")
	@Expose
	private Integer numberpacketsPerport;
	@SerializedName("ports")
	@Expose
	private String ports;
	@SerializedName("protocol")
	@Expose
	private String protocol; 
	
	
	public ScriptProperties()
	{
		super();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name)
	{
	  this.name = name;	
	}
	
	public String getIP()
	{
		return IP;
	}
	
	public void SetIP(String IP)
	{
		this.IP= IP;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public Integer getNumberPacketsPerPort()
	{
		return numberpacketsPerport;
	}
	
	public void setNumberPacketsPerPort(Integer numberPacketsPerPort)
	{
		this.numberpacketsPerport = numberPacketsPerPort;
	}
	
	public String getPorts()
	{
		return ports;
	}
	
	public void setPorts(String ports)
	{
		this.ports = ports;
	}
	
	public String getProtocol()
	{
		return protocol;
	}
	
	public void setProtocol(String protocol)
	{
		this.protocol = protocol;
	}
}

