package net.vmjforums.computer.init;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.vmjforums.computer.blocks.BlockCase1;
import net.vmjforums.computer.blocks.Peripherals;
import net.vmjforums.computer.blocks.UniversalRouter;

public class ModBlocks {
	
	public static Block case1;
	public static Block peripherals;
	public static Block router;
	
	public static void init(){
		case1 = new BlockCase1();
		peripherals = new Peripherals();
		router = new UniversalRouter();
	}
	public static void register(){
		registerBlock(case1);
		registerBlock(peripherals);
		registerBlock(router);
	}
	private static void registerBlock(Block block){
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	public static void registerRenders() {
		registerRender(case1);
		registerRender(peripherals);
		registerRender(router);
	}
	private static void registerRender(Block block){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	
}
