package com.enzer.wilsonsmpblocks.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Block item representing the different subtypes of sandstone brick.
 * 
 * @author Enzer
 * @author Tuxide
 * @version %I%, %G%
 * @since 1.8
 */
public class ItemBlockBrickExtraStairs extends ItemBlock
{

	/**
	 * Constructor.
	 * 
	 * @param block
	 *            The block.
	 */
	public ItemBlockBrickExtraStairs(final Block block)
	{
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(final int metadata)
	{
		return metadata;
	}

	@Override
	public String getUnlocalizedName(final ItemStack stack)
	{
		return super.getUnlocalizedName();
	}
}
