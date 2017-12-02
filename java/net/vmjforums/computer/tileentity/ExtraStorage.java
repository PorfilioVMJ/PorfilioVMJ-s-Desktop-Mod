package net.vmjforums.computer.tileentity;

import java.util.HashMap;

public class ExtraStorage {
	
	String routerIp = "Router Ip";
	
	HashMap perDeviceRouter = new HashMap<String, String>();
	
	public String getPerDeviceRouter(String deviceName) {
		return (String)perDeviceRouter.get(deviceName);
	}

	public String getRouterIp() {
		return routerIp;
	}

	public void setRouterIp(String deviceName,String routerIp) {
		this.routerIp = routerIp;
		perDeviceRouter.put(deviceName, routerIp);
		System.out.println("Given Router@"+routerIp+" to "+deviceName);
	}
	
}
