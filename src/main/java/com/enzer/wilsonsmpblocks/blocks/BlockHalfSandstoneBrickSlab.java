package com.enzer.wilsonsmpblocks.blocks;

import net.minecraft.block.material.Material;

public class BlockHalfSandstoneBrickSlab extends BlockSandstoneBrickSlab
{
	public BlockHalfSandstoneBrickSlab(Material materialIn)
	{
		super(materialIn);
		this.setUnlocalizedName("sandstonebrickslab");
	}

	/**
	 * Gets whether or not this is double height.
	 * @return always false.
	 */
	@Override
	public final boolean isDouble()
	{
		return false;
	}
}
