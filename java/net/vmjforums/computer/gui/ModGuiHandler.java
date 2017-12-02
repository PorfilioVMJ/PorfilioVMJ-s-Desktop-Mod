package net.vmjforums.computer.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.vmjforums.computer.gui.router.GuiRouterScreen;
import net.vmjforums.computer.tileentity.ExtraStorage;

public class ModGuiHandler implements IGuiHandler{

	public static final int OS_GUI = 0, ROUTER_GUI = 1;
	
	ExtraStorage storageModule1 = new ExtraStorage();
	
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
    	int bx = (int) (player.getLookVec().xCoord*50D);
    	int by = (int) (player.posY+player.getLookVec().yCoord*50D);
    	int bz = (int) (player.posZ+player.getLookVec().zCoord*50D);
    	
        if (ID == OS_GUI)
        	return new GuiOSTileEntity(storageModule1);
        else if(ID == ROUTER_GUI)
        	return new GuiRouterScreen(bx,by,bz, storageModule1);
        
        return null;
    }
}
