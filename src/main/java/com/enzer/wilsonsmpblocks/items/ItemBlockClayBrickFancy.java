package com.enzer.wilsonsmpblocks.items;

import com.enzer.wilsonsmpblocks.blocks.BlockClayBrickFancy;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Block item representing the different subtypes of fancy clay brick.
 * 
 * @author Enzer
 * @author Tuxide
 * @version %I%, %G%
 * @since 1.8
 */
public class ItemBlockClayBrickFancy extends ItemBlock {

	/**
	 * Constructor.
	 * 
	 * @param block
	 *            The block.
	 */
	public ItemBlockClayBrickFancy(final Block block) {
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
		BlockClayBrickFancy.Type type = BlockClayBrickFancy.Type
				.byMetadata(stack.getMetadata());
		return super.getUnlocalizedName() + "." + type.getName();
	}
}
