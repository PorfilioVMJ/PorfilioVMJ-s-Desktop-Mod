package net.vmjforums.computer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.vmjforums.computer.init.ModBlocks;
import net.vmjforums.computer.init.ModItems;
import net.vmjforums.computer.proxy.CommonProxy;
import net.vmjforums.computer.tileentity.TileEntityCase1;

@Mod(modid = Reference.modid, name = Reference.name, version = Reference.version, acceptedMinecraftVersions = Reference.accepted_versions)
public class ComputerMod {
	
	@Instance
	public static ComputerMod instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		System.out.println("Pre Init");
		
		ModItems.init();
		ModItems.register();
		
		ModBlocks.init();
		ModBlocks.register();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent e){
		System.out.println("Init");
		proxy.init();
		
		GameRegistry.registerTileEntity(TileEntityCase1.class, Reference.modid + "TileEntityCase1");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		System.out.println("Post Init");
	}
	
	
}
