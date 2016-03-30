package com.enzer.wilsonsmpblocks.items;
import com.enzer.wilsonsmpblocks.blocks.BlockDoubleBrickExtraSlab;
import com.enzer.wilsonsmpblocks.blocks.BlockHalfBrickExtraSlab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemBlockBrickExtraSlab extends ItemSlab
{
	/**
	 * Initializes a new instance of the ItemBlockStainedBrickSlab class.
	 * @param block the block behind the item.
	 * @param slab the half height slab.
	 * @param doubleSlab the full height slab.
	 * @param stacked whether or not the block is the stacked version.
	 */
	public ItemBlockBrickExtraSlab(final Block block, final BlockHalfBrickExtraSlab slab, final BlockDoubleBrickExtraSlab doubleSlab, final Boolean stacked)
	{
		super(block, slab, doubleSlab);
	}
}
