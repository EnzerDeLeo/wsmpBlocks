package com.enzer.wilsonsmpblocks.blocks;

import com.enzer.wilsonsmpblocks.WSMPmain;
import com.enzer.wilsonsmpblocks.blocks.BlockSandstoneBrick.Type;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public abstract class BlockSandstoneBrickSlab extends BlockSlab
{
	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BlockSandstoneBrick.Type.class);
	public static final String NAME = "sandstonebrickslab";
	
	public BlockSandstoneBrickSlab(Material materialIn)
	{
		super(materialIn);

		IBlockState blockState = this.blockState.getBaseState();

		if (!this.isDouble())
		{
			blockState = blockState.withProperty(HALF, EnumBlockHalf.BOTTOM);
		}

		if (!this.isDouble())
		{
			setCreativeTab(WSMPmain.tabWSMPBlocks);
		}

		this.setDefaultState(blockState.withProperty(VARIANT, BlockSandstoneBrick.Type.TAN));
		this.setHardness(1.5F);
		this.setResistance(5F);
		this.setHarvestLevel("pickaxe", 1);
		this.useNeighborBrightness = !this.isDouble();
	}

	/**
	 * Gets the unlocalized name based on metadata/damage.
	 * @param metadata block metadata.
	 * @return the unlocalized name.
	 */
	@Override
	public final String getUnlocalizedName(final int metadata)
	{
		return NAME + "." + BlockSandstoneBrick.Type.byMetadata(metadata).getUnlocalizedName();
	}

	/**
	 * Gets the value of the variant property based on the item.
	 * @param itemStack item stack.
	 * @return the variant value null.
	 */
	@Override
	public final Object getVariant(final ItemStack stack)
	{
		return BlockSandstoneBrick.Type.byMetadata(stack.getMetadata() & 7);
	}

	/**
	 * Gets the variant property.
	 * @return the variant property null.
	 */
	@Override
	public final IProperty getVariantProperty()
	{
		return VARIANT;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(final Item itemIn, final CreativeTabs tab, final List list)
	{
		for (Type type : Type.values())
		{
			final int metadata = type.getMetadata();
			final ItemStack stack = new ItemStack(itemIn, 1, metadata);
			list.add(stack);
		}
	}

	/**
	 * Gets a block state from metadata.
	 * @param meta the metadata or color value.
	 * @return a block state with the meta encoded as the variant property.
	 */
	@Override
	public final IBlockState getStateFromMeta(final int meta)
	{
		IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, BlockSandstoneBrick.Type.byMetadata(meta & 7));

		if (!this.isDouble())
		{
			iblockstate = iblockstate.withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
		}

		return iblockstate;
	}

	/**
	 * Gets the metadata value from a block state.
	 * @param state the block state.
	 * @return the metadata or color value.
	 */
	@Override
	public final int getMetaFromState(final IBlockState state)
	{
		byte b0 = 0;
		int i = b0 | ((BlockSandstoneBrick.Type) state.getValue(VARIANT)).getMetadata();

		if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP)
		{
			i |= 8;
		}

		return i;
	}

	/**
	 * Gets the damage for the block's item when dropped.
	 * @param state the block's state.
	 * @return the metadata or color value.
	 */
	@Override
	public final int damageDropped(final IBlockState state)
	{
		return ((BlockSandstoneBrick.Type) state.getValue(VARIANT)).getMetadata();
	}

	/**
	 * Gets the item dropped when the block is broken.
	 * @param blockState the block's state.
	 * @param random the random number generator
	 * @param unused an integer.
	 * @return the half slab item.
	 */
	@Override
	public final Item getItemDropped(final IBlockState blockState, final java.util.Random random, final int unused)
	{
		return GameRegistry.findItem(WSMPmain.MODID, this.getUnlocalizedName());
	}

	/**
	 * Gets the item dropped when the block is broken.
	 * @param world the world
	 * @param blockPos the block position.
	 * @return the item dropped, the half slab.
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public final net.minecraft.item.Item getItem(final net.minecraft.world.World world, final net.minecraft.util.BlockPos blockPos)
	{
		return GameRegistry.findItem(WSMPmain.MODID, this.getUnlocalizedName());
	}

	/**
	 * Creates the block state object.
	 * @return the block state with properties defined.
	 */
	@Override
	protected final BlockState createBlockState()
	{
		return this.isDouble() ? new BlockState(this, new IProperty[] { VARIANT }) : new BlockState(this, new IProperty[] { HALF, VARIANT });
	}
}
