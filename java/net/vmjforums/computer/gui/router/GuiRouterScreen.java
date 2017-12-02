package net.vmjforums.computer.gui.router;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraftforge.fml.client.config.GuiButtonExt;

public class GuiRouterScreen extends GuiScreen{
	
	private GuiButton exit;
	private GuiButtonExt enterPw;
	private GuiTextField router2PosInput;
	
	public static int x, y, z;
	
	ArrayList<String> connectedIps = new ArrayList<String>();
	
	public GuiRouterScreen(int lposX, int lposY, int lposZ){
		this.x = lposX;
		this.y = lposY;
		this.z = lposZ;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.drawCenteredString(fontRendererObj, "Router", this.width/2, 10, 0xFFFFFF);
		this.drawCenteredString(fontRendererObj, "Connection Address: "+x+"."+y+"."+z, this.width/4, 30, 0xFFFFFF);
		this.router2PosInput.drawTextBox();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		this.buttonList.add(this.exit = new GuiButton(0, 10, 10, 10, 10, "X"));
		this.buttonList.add(this.exit = new GuiButtonExt(1, this.width/4+55, 43, 60, 25, "ENTER"));
        this.router2PosInput = new GuiTextField(1, this.fontRendererObj, this.width/4-80, 45, 130, 20);
        router2PosInput.setMaxStringLength(23);
        router2PosInput.setText("Device Router");
        this.router2PosInput.setFocused(true);
		super.initGui();
	}
	
	@Override
	public void updateScreen() {
		super.updateScreen();
		this.router2PosInput.updateCursorCounter();
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
		this.router2PosInput.textboxKeyTyped(typedChar, keyCode);
	}
	
	protected void mouseClicked(int x, int y, int btn) {
        try {
			super.mouseClicked(x, y, btn);
		} catch (IOException e) {
			e.printStackTrace();
		}
        this.router2PosInput.mouseClicked(x, y, btn);
    }
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {

		super.actionPerformed(button);
	}
	
}
