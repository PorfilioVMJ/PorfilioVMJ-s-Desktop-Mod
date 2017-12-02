package net.vmjforums.computer.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.vmjforums.computer.Reference;
import net.vmjforums.computer.init.ModItems;
import net.vmjforums.computer.tileentity.TileEntityCase1;

public class BlockCase1 extends Block implements ITileEntityProvider{

	// 1 / 16 = 0.625
	
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625 * 3, 0, 0, 0.0625 * 13, 0.0625 * 20, 0.0625 * 16);
	
	public BlockCase1() {
		super(Material.IRON);
		setUnlocalizedName(Reference.ComputerBlocks.case1.getUnlocalizedName());
		setRegistryName(Reference.ComputerBlocks.case1.getRegistryName());
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BOUNDING_BOX;
	}
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean p_185477_7_) {
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityCase1();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote){
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			ItemStack heldItem = playerIn.getHeldItemMainhand();
			if(tileEntity instanceof TileEntityCase1){
				TileEntityCase1 case1 = (TileEntityCase1) tileEntity;
				if(heldItem != null){
					if(heldItem.getItem() == ModItems.board){
						if(case1.addMobo()){
							playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, ItemStack.EMPTY);
							return true;
						}
					}
				}
				case1.removeMobo();
			}
		}
			return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
}
