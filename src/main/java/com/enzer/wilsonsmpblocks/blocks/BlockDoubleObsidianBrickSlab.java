package com.enzer.wilsonsmpblocks.blocks;

import net.minecraft.block.material.Material;

public class BlockDoubleObsidianBrickSlab extends BlockObsidianBrickSlab
{
	public BlockDoubleObsidianBrickSlab(Material materialIn)
	{
		super(materialIn);
		this.setUnlocalizedName(this.getID());
	}

	/**
	 * Gets whether or not this is a double stacked slab.
	 * @return always true.
	 */
	@Override
	public final boolean isDouble()
	{
		return true;
	}
}
