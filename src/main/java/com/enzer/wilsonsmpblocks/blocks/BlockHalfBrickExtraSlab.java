package com.enzer.wilsonsmpblocks.blocks;

import net.minecraft.block.material.Material;

public class BlockHalfBrickExtraSlab extends BlockBrickExtraSlab
{
	public BlockHalfBrickExtraSlab(Material materialIn)
	{
		super(materialIn);
		this.setUnlocalizedName("brickextraslab");
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
