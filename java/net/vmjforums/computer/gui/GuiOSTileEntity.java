package net.vmjforums.computer.gui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.config.GuiButtonExt;
import net.vmjforums.computer.Reference;
import net.vmjforums.computer.gui.os.components.SubBiOS;
import net.vmjforums.computer.tileentity.ExtraStorage;
import net.vmjforums.computer.tileentity.TileEntityPeripherals;

public class GuiOSTileEntity extends GuiScreen{
	
	private GuiButton exit;
	private GuiButtonExt enterIp;
	private GuiLabel currentScreen;
	private GuiTextField routerIp;
	SubBiOS bios = new SubBiOS();
	public int pcs = 0;
	
	ExtraStorage storage;
	
	ResourceLocation background1 = new ResourceLocation("vmjcm:gui/textures/background1.png");
	private static final ResourceLocation BG_TEXTURE = new ResourceLocation(Reference.modid, "gui/textures/background1.png");
	
    public GuiOSTileEntity(ExtraStorage storage){
    	this.storage = storage;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.drawCenteredString(fontRendererObj, "Computers Nearby", 60, 40, 0xFFFFFF);
		this.routerIp.drawTextBox();
	    super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		this.buttonList.add(this.exit = new GuiButton(0, 10, 10, 10, 10, "X"));
		this.buttonList.add(bios.pcSearch = new GuiButtonExt(1, 10, 30, 100, 10, "Search For PCs"));
		this.buttonList.add(this.enterIp = new GuiButtonExt(2, 145, this.height-32, 60, 24, "ENTER"));
		this.routerIp = new GuiTextField(2, this.fontRendererObj, 10, this.height-30, 130, 20);
		routerIp.setMaxStringLength(16);
		routerIp.setText(storage.getRouterIp());
		System.out.println(TileEntityPeripherals.getRouterIp());
        this.routerIp.setFocused(true);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
	    if (button == this.exit) {
	        //Main.packetHandler.sendToServer(...);
	        this.mc.displayGuiScreen(null);
	        if (this.mc.currentScreen == null)
	            this.mc.setIngameFocus();
	    }else if (button == bios.pcSearch){
	        //Main.packetHandler.sendToServer(...);
	        if (this.mc.currentScreen == null) {
	            GlStateManager.color(1, 1, 1, 1);
		        this.mc.getTextureManager().bindTexture(BG_TEXTURE);
		        this.drawTexturedModalRect(60, 70, 0, 0, 256, 256);
		        this.mc.setIngameFocus();
	        }
	    }else if(button==this.enterIp) {
	    	if (this.mc.currentScreen == null) {
	    		
	    	}
	    }
	}
	
	
	
	@Override
	public void updateScreen() {
		super.updateScreen();
        GlStateManager.color(1, 1, 1, 1);
        this.mc.getTextureManager().bindTexture(BG_TEXTURE);
        int x = (width - 248) / 2;
        int y = (height - 166) / 2;
        this.drawTexturedModalRect(60, 70, 0, 0, 256, 256);
        //this.drawTexturedModalRect(xCoord, yCoord, textureSprite, widthIn, heightIn);
		this.routerIp.updateCursorCounter();
	}
	
	 protected void mouseClicked(int x, int y, int btn) {
	        try {
				super.mouseClicked(x, y, btn);
			} catch (IOException e) {
				e.printStackTrace();
			}
	        this.routerIp.mouseClicked(x, y, btn);
	        if(x>=enterIp.xPosition && x<enterIp.xPosition+enterIp.width) {
	        	if(y>=enterIp.yPosition&&y<=enterIp.yPosition+enterIp.height) {
	        		storage.setRouterIp(routerIp.getText());
	        		//DEPRECATED (Does not update, Code is incorrect) TileEntityPeripherals.setRouterIp(routerIp.getText());
	        		
		        	System.out.println("New Router = "+routerIp.getText());
	        	}
	        }
	 }
	
	protected void keyTyped(char par1, int par2){
        try {
			super.keyTyped(par1, par2);
		} catch (IOException e) {
			e.printStackTrace();
		}
        this.routerIp.textboxKeyTyped(par1, par2);
    }
	
	
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
