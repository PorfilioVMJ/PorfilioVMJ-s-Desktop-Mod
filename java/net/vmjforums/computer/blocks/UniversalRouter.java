package net.vmjforums.computer.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.vmjforums.computer.ComputerMod;
import net.vmjforums.computer.Reference;
import net.vmjforums.computer.gui.router.GuiRouterScreen;
import net.vmjforums.computer.tileentity.TileEntityRouter;

public class UniversalRouter extends Block implements ITileEntityProvider{
	
	//x1, y1, z1, x2, y2, z2
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625*2, 0, 0.0625*1, 0.0625*14, 0.0625*6, 0.0625*12);
	
	public UniversalRouter() {
		super(Material.IRON);
		setUnlocalizedName(Reference.ComputerBlocks.router.getUnlocalizedName());
		setRegistryName(Reference.ComputerBlocks.router.getRegistryName());
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BOUNDING_BOX;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityRouter();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if (worldIn.isRemote) {
            playerIn.openGui(ComputerMod.instance, 1, worldIn, (int) playerIn.posX, (int) playerIn.posY, (int) playerIn.posZ);
        }
		
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
}
