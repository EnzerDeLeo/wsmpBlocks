package com.enzer.wilsonsmpblocks.items;
import com.enzer.wilsonsmpblocks.blocks.BlockDoubleObsidianBrickSlab;
import com.enzer.wilsonsmpblocks.blocks.BlockHalfObsidianBrickSlab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemBlockObsidianBrickSlab extends ItemSlab
{
	/**
	 * Initializes a new instance of the ItemBlockObsidianBrickSlab class.
	 * @param block the block behind the item.
	 * @param slab the half height slab.
	 * @param doubleSlab the full height slab.
	 * @param stacked whether or not the block is the stacked version.
	 */
	public ItemBlockObsidianBrickSlab(final Block block, final BlockHalfObsidianBrickSlab slab, final BlockDoubleObsidianBrickSlab doubleSlab, final Boolean stacked)
	{
		super(block, slab, doubleSlab);
	}
}
