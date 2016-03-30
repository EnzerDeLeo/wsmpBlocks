package com.enzer.wilsonsmpblocks.blocks;

import com.enzer.wilsonsmpblocks.WSMPmain;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockBrickExtraStairs extends BlockStairs
{
	public static final String NAME = "brickextrastairs";
	
	public BlockBrickExtraStairs(IBlockState modelState)
	{
		super(modelState);
		
		this.setHardness(1.5F);
		this.setResistance(5F);
		this.setHarvestLevel("pickaxe", 1);
		this.setCreativeTab(WSMPmain.tabWSMPBlocks);
	}
}
