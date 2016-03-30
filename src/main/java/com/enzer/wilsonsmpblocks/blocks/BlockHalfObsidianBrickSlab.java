package com.enzer.wilsonsmpblocks.blocks;

import net.minecraft.block.material.Material;

public class BlockHalfObsidianBrickSlab extends BlockObsidianBrickSlab
{
	public BlockHalfObsidianBrickSlab(Material materialIn)
	{
		super(materialIn);
		this.setUnlocalizedName(this.getID());
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
