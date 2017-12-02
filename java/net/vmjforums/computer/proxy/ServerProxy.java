package net.vmjforums.computer.proxy;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.vmjforums.computer.ComputerMod;
import net.vmjforums.computer.gui.ModGuiHandler;

public class ServerProxy implements CommonProxy{

	@Override
	public void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(ComputerMod.instance, new ModGuiHandler());
	}
	
	
	
}
