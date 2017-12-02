package net.vmjforums.computer.items;

import net.minecraft.item.Item;
import net.vmjforums.computer.Reference;

public class ItemBoard extends Item{
	
	public ItemBoard() {
		setUnlocalizedName(Reference.ComputerItems.BOARD.getUnlocalizedName());
		setRegistryName(Reference.ComputerItems.BOARD.getRegistryName());
	}
}
