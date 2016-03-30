package com.enzer.wilsonsmpblocks.blocks;

import net.minecraft.block.material.Material;

public class BlockDoubleSandstoneBrickSlab extends BlockSandstoneBrickSlab
{
	public BlockDoubleSandstoneBrickSlab(Material materialIn)
	{
		super(materialIn);
		this.setUnlocalizedName("sandstonebrickslab_double");
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
