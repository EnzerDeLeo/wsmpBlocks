package com.enzer.wilsonsmpblocks.items;
import com.enzer.wilsonsmpblocks.blocks.BlockDoubleSandstoneBrickSlab;
import com.enzer.wilsonsmpblocks.blocks.BlockHalfSandstoneBrickSlab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemBlockSandstoneBrickSlab extends ItemSlab
{
	/**
	 * Initializes a new instance of the ItemBlockStainedBrickSlab class.
	 * @param block the block behind the item.
	 * @param slab the half height slab.
	 * @param doubleSlab the full height slab.
	 * @param stacked whether or not the block is the stacked version.
	 */
	public ItemBlockSandstoneBrickSlab(final Block block, final BlockHalfSandstoneBrickSlab slab, final BlockDoubleSandstoneBrickSlab doubleSlab, final Boolean stacked)
	{
		super(block, slab, doubleSlab);
	}
}
