package net.vmjforums.computer.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.vmjforums.computer.items.ItemBoard;
import net.vmjforums.computer.items.ItemCPU;
import net.vmjforums.computer.items.ItemRam;

public class ModItems {
	
	public static Item ram;
	public static Item cpu;
	public static Item board;

	public static void init(){
		ram = new ItemRam();
		cpu = new ItemCPU();
		board = new ItemBoard();
	}
	public static void register(){
		GameRegistry.register(ram);
		GameRegistry.register(cpu);
		GameRegistry.register(board);
	}
	public static void registerRenders() {
		registerRender(ram);
		registerRender(cpu);
		registerRender(board);
	}
	private static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
