package net.vmjforums.computer.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPeripherals extends TileEntity{
	
	static String routerIp;
	static String permRouterIp;
	
	public TileEntityPeripherals(String routerIp) {
		this.routerIp = routerIp;
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setString("sRouterIp", routerIp);
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		permRouterIp = compound.getString("sRouterIp");
		super.readFromNBT(compound);
	}
	
	@Override
	public NBTTagCompound getTileData() {
		return super.getTileData();
		
	}

	public static String getRouterIp() {
		return permRouterIp;
	}

	public static void setRouterIp(String newRouterIp) {
		routerIp = newRouterIp;
		System.out.println(newRouterIp + " New:Test " + routerIp);
	}
	
}
