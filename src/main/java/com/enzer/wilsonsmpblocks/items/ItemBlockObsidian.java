package com.enzer.wilsonsmpblocks.items;

import com.enzer.wilsonsmpblocks.blocks.BlockObsidian;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Block item representing the different subtypes of nether block.
 * 
 * @author Enzer
 * @author Tuxide
 * @version %I%, %G%
 * @since 1.8
 */
public class ItemBlockObsidian extends ItemBlock {

	/**
	 * Constructor.
	 * 
	 * @param block
	 *            The block.
	 */
	public ItemBlockObsidian(final Block block) {
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(final int metadata) {
		return metadata;
	}

	@Override
	public String getUnlocalizedName(final ItemStack stack) {
		BlockObsidian.Type type = BlockObsidian.Type
				.byMetadata(stack.getMetadata());
		return super.getUnlocalizedName() + "." + type.getName();
	}
}
