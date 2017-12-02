package net.vmjforums.computer.items;

import net.minecraft.item.Item;
import net.vmjforums.computer.Reference;

public class ItemCPU extends Item{
	
	public ItemCPU() {
		setUnlocalizedName(Reference.ComputerItems.CPU.getUnlocalizedName());
		setRegistryName(Reference.ComputerItems.CPU.getRegistryName());
	}
}
