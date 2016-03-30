package com.enzer.wilsonsmpblocks.items;

import com.enzer.wilsonsmpblocks.blocks.BlockGlowstoneColor;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Block item representing the different subtypes of colored glowstone.
 * 
 * @author Enzer
 * @author Tuxide
 * @version %I%, %G%
 * @since 1.8
 */
public class ItemBlockGlowstoneColor extends ItemBlock {

	/**
	 * Constructor.
	 * 
	 * @param block
	 *            The block.
	 */
	public ItemBlockGlowstoneColor(final Block block) {
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
		BlockGlowstoneColor.Type type = BlockGlowstoneColor.Type.byMetadata(stack
				.getMetadata());
		return super.getUnlocalizedName() + "." + type.getName();
	}
}
