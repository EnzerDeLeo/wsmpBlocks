package com.enzer.wilsonsmpblocks.blocks;

import com.enzer.wilsonsmpblocks.WSMPmain;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockObsidianBrickSlab extends BlockSlab
{
	/**
	* The property used for the variant.
	* Needed for interactions with ItemSlab.
	*/
	private static final PropertyBool VARIANT_PROPERTY = PropertyBool.create("variant");
	private static final int HALF_META_BIT = 8;
	public static final String NAME = "obsidianbrickslab";

	public BlockObsidianBrickSlab(Material materialIn)
	{
		super(materialIn);

		IBlockState blockState = this.blockState.getBaseState();
		blockState = blockState.withProperty(VARIANT_PROPERTY, false);

		if (!this.isDouble())
		{
			blockState = blockState.withProperty(HALF, EnumBlockHalf.BOTTOM);
		}

		if (!this.isDouble())
		{
			setCreativeTab(WSMPmain.tabWSMPBlocks);
		}

		setDefaultState(blockState);
		this.setHardness(2F);
		this.setResistance(2000F);
		this.setHarvestLevel("pickaxe", 2);
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
		return this.getUnlocalizedName();
	}

	/**
	 * Gets the value of the variant property based on the item.
	 * @param itemStack item stack.
	 * @return the variant value null.
	 */
	@Override
	public final Object getVariant(final ItemStack itemStack)
	{
		return false;
	}

	/**
	 * Gets the variant property.
	 * @return the variant property null.
	 */
	@Override
	public final IProperty getVariantProperty()
	{
		return VARIANT_PROPERTY;
	}

	/**
	 * Gets a block state from metadata.
	 * @param meta the metadata or color value.
	 * @return a block state with the meta encoded as the variant property.
	 */
	@Override
	public final IBlockState getStateFromMeta(final int meta)
	{
		IBlockState blockState = this.getDefaultState();
		blockState = blockState.withProperty(VARIANT_PROPERTY, false);

		if (!this.isDouble())
		{
			EnumBlockHalf value = EnumBlockHalf.BOTTOM;
			if ((meta & HALF_META_BIT) != 0)
			{
				value = EnumBlockHalf.TOP;
			}

			blockState = blockState.withProperty(HALF, value);
		}

		return blockState;
	}

	/**
	 * Gets the metadata value from a block state.
	 * @param state the block state.
	 * @return the metadata or color value.
	 */
	@Override
	public final int getMetaFromState(final IBlockState state)
	{
		if (this.isDouble())
		{
			return 0;
		}

		if ((EnumBlockHalf) state.getValue(HALF) == EnumBlockHalf.TOP)
		{
			return HALF_META_BIT;
		}
		else
		{
			return 0;
		}
	}

	/**
	 * Gets the damage for the block's item when dropped.
	 * @param state the block's state.
	 * @return the metadata or color value.
	 */
	@Override
	public final int damageDropped(final IBlockState state)
	{
		return 0;
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
		return GameRegistry.findItem(WSMPmain.MODID, getID());
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
		return GameRegistry.findItem(WSMPmain.MODID, getID());
	}

	/**
	 * Creates the block state object.
	 * @return the block state with properties defined.
	 */
	@Override
	protected final BlockState createBlockState()
	{
		if (this.isDouble())
		{
			return new BlockState(this, new IProperty[] { VARIANT_PROPERTY });
		}
		else
		{
			return new BlockState(this, new IProperty[] { VARIANT_PROPERTY, HALF });
		}
	}

	public String getID()
	{
		return isDouble() ? NAME + "_double" : NAME;
	}
}
