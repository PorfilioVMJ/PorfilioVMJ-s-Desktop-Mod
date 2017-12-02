package net.vmjforums.computer.gui.os.components;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.config.GuiButtonExt;

public class SubBiOS extends GuiScreen{
	
	ResourceLocation background1 = new ResourceLocation("vmjcm:gui/textures/background1.png");
	public GuiButtonExt pcSearch;
	
	public SubBiOS() {
		System.out.println("Sub BIOS Activated");
		//this.drawRect(30, 30, 60, 60, 0xFF0000);
		//this.buttonList.add(this.pcSearch = new GuiButtonExt(1, 50, 10, 30, 40 "Search for PC"));
		
	}
	
}
