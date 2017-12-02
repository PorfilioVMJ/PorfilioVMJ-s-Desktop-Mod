package net.vmjforums.computer.proxy;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.vmjforums.computer.ComputerMod;
import net.vmjforums.computer.gui.ModGuiHandler;
import net.vmjforums.computer.init.ModBlocks;
import net.vmjforums.computer.init.ModItems;
import net.vmjforums.computer.tileentity.TileEntityCase1;
import net.vmjforums.computer.tileentity.render.RendererCase;

public class ClientProxy implements CommonProxy{

	@Override
	public void init() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(ComputerMod.instance, new ModGuiHandler());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCase1.class, new RendererCase());
	}
	
	
	
}
