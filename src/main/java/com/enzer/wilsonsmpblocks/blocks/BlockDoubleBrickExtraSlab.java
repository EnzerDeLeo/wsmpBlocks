package com.enzer.wilsonsmpblocks.blocks;

import net.minecraft.block.material.Material;

public class BlockDoubleBrickExtraSlab extends BlockBrickExtraSlab
{
	public BlockDoubleBrickExtraSlab(Material materialIn)
	{
		super(materialIn);
		this.setUnlocalizedName("brickextraslab_double");
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
