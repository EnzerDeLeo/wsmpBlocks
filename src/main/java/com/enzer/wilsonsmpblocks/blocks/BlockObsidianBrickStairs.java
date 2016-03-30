package com.enzer.wilsonsmpblocks.blocks;

import com.enzer.wilsonsmpblocks.WSMPmain;
import com.enzer.wilsonsmpblocks.items.ItemBlockObsidianBrickStairs;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockObsidianBrickStairs extends BlockStairs
{
	public static final String NAME = "obsidianbrickstairs";

	public BlockObsidianBrickStairs(IBlockState modelState)
	{
		super(modelState);

		this.setHardness(2F);
		this.setResistance(2000F);
		this.setHarvestLevel("pickaxe", 2);
		this.setCreativeTab(WSMPmain.tabWSMPBlocks);
	}

	public static void register()
	{
		final BlockObsidianBrickStairs blockObsidianBrickStairs = new BlockObsidianBrickStairs(GameRegistry.findBlock(WSMPmain.MODID, "obsidian").getDefaultState());
		blockObsidianBrickStairs.setUnlocalizedName(NAME);
		GameRegistry.registerBlock(blockObsidianBrickStairs, ItemBlockObsidianBrickStairs.class, NAME);
	}
}
