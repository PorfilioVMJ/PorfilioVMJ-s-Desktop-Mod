package net.vmjforums.computer.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenDoublePlant;
import net.vmjforums.computer.init.ModItems;

public class TileEntityCase1 extends TileEntity{
	
	public int mobo = 0;	
	
	
	public boolean addMobo(){
		if(!world.isRemote){
			if(mobo==0){
				mobo=1;
				markDirty();
				IBlockState state = Minecraft.getMinecraft().world.getBlockState(pos);
				Minecraft.getMinecraft().world.notifyBlockUpdate(pos, state, state, 3);
				Minecraft.getMinecraft().renderGlobal.notifyBlockUpdate(getWorld(), pos, state, state, 3);
				return true;
			}
		}
		return false;
	}
	
	public void removeMobo(){
		if(!world.isRemote){
			if(mobo == 1){
				world.spawnEntity(new EntityItem(world, pos.getX() + 0.2, pos.getY() + 1, pos.getZ() + 0.2, new ItemStack(ModItems.board)));
				mobo=0;
				markDirty();
				IBlockState state = Minecraft.getMinecraft().world.getBlockState(pos);
				Minecraft.getMinecraft().world.notifyBlockUpdate(pos, state, state, 3);
				Minecraft.getMinecraft().renderGlobal.notifyBlockUpdate(getWorld(), pos, state, state, 3);

			}
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		//compound.setInteger("HasMobo", this.mobo);
		writeUpdateTag(compound);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		//this.mobo = compound.getInteger("HasMobo");
		readUpdateTag(compound);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		NBTTagCompound tag = pkt.getNbtCompound();
		readUpdateTag(tag);
	}
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound tag = new NBTTagCompound();
		this.writeUpdateTag(tag);
		return new SPacketUpdateTileEntity(pos, getBlockMetadata(), tag);
	}
	
	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound tag = super.getUpdateTag();
		writeUpdateTag(tag);
		return tag;
	}
	
	public void writeUpdateTag(NBTTagCompound tag) {
		tag.setInteger("HasMobo", this.mobo);
	}
	
	public void readUpdateTag(NBTTagCompound tag) {
		this.mobo = tag.getInteger("HasMobo");
	}
}
