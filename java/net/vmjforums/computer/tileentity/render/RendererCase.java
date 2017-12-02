package net.vmjforums.computer.tileentity.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.vmjforums.computer.init.ModItems;
import net.vmjforums.computer.tileentity.TileEntityCase1;

public class RendererCase extends TileEntitySpecialRenderer<TileEntityCase1>{
	
	private static final EntityItem ITEMMOBO = new EntityItem(Minecraft.getMinecraft().world, 0, 0, 0, new ItemStack(ModItems.board));
	
	@Override
	public void renderTileEntityAt(TileEntityCase1 te, double x, double y, double z, float partialTicks,int destroyStage) {
		super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);
		
		ITEMMOBO.hoverStart = 0F;
		
		GlStateManager.pushMatrix();{
			GlStateManager.translate(x, y, z);
			GlStateManager.rotate(180F, 0, 1, 0);
			GlStateManager.rotate(90F, 0, 0, 1);
			GlStateManager.translate(0.7, 0.4, -0.64);
			GlStateManager.scale(0.8, 1, 0.8);
			if(te.mobo==1){
				Minecraft.getMinecraft().getRenderManager().doRenderEntity(ITEMMOBO, 0, 0, 0, 0F, 0F, false);
			}else{
				
			}
		}
		GlStateManager.popMatrix();
	}
	
}
