package net.vmjforums.computer.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.vmjforums.computer.gui.router.GuiRouterScreen;

public class ModGuiHandler implements IGuiHandler{

	public static final int OS_GUI = 0, ROUTER_GUI = 1;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == OS_GUI)
            return null;
        else if(ID == ROUTER_GUI)
        	return null;
       
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == OS_GUI)
        	return new GuiOSTileEntity();
        else if(ID == ROUTER_GUI)
        	return new GuiRouterScreen(x,y,z);
        
        return null;
    }
}
