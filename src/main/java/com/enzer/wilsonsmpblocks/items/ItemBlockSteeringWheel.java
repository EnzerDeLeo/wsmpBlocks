package com.enzer.wilsonsmpblocks.items;

import com.enzer.wilsonsmpblocks.blocks.BlockSteeringWheel;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Block item representing the different of steering wheel.
 * 
 * @author Enzer
 * @author Tuxide
 * @version %I%, %G%
 * @since 1.8
 */
public class ItemBlockSteeringWheel extends ItemBlock {

	/**
	 * Constructor.
	 * 
	 * @param block
	 *            The block.
	 */
	public ItemBlockSteeringWheel(final Block block) {
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
		BlockSteeringWheel.Type type = BlockSteeringWheel.Type.byMetadata(stack.getMetadata());
		return super.getUnlocalizedName() + "." + type.getName();
	}
}
