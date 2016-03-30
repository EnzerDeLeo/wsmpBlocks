package com.enzer.wilsonsmpblocks.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.enzer.wilsonsmpblocks.WSMPmain;
import com.enzer.wilsonsmpblocks.items.ItemBlockCrate;

/**
 * Block representing a crate.
 * 
 * @author Enzer
 * @author Tuxide
 * @version %I%, %G%
 * @since 1.8
 */
public class BlockCrate extends Block {
	@SuppressWarnings("javadoc")
	public static final String NAME = "crate";
	private static final PropertyEnum VARIANT = PropertyEnum.create("variant",
			Type.class);

	/**
	 * Types of crates.
	 * 
	 * @author Tuxide
	 *
	 */
	@SuppressWarnings("javadoc")
	public static enum Type implements HasMetadata {
		CLOSED(0, "closed"), APPLE(1, "apple"), BERRY(2, "berry"), CARROT(3,
				"carrot"), FISH(4, "fish"), GRAIN(5, "grain"), INGOT(6, "ingot"), POTATO(
				7, "potato"), SUGAR(8, "sugar");

		private static final Type[] META_LOOKUP = new Type[values().length];

		private final int meta;
		private final String name;
		private final String unlocalizedName;

		private Type(final int meta, final String name) {
			this(meta, name, name);
		}

		private Type(final int meta, final String name,
				final String unlocalizedName) {
			this.meta = meta;
			this.name = name;
			this.unlocalizedName = unlocalizedName;
		}

		@Override
		public int getMetadata() {
			return meta;
		}

		@Override
		public String toString() {
			return name;
		}

		@Override
		public String getName() {
			return name;
		}

		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}

		public static Type byMetadata(final int meta) {
			int fixed = meta < 0 || meta >= META_LOOKUP.length ? 0 : meta;
			return META_LOOKUP[fixed];
		}

		static {
			int i = 0;
			for (final Type type : values()) {
				META_LOOKUP[i++] = type;
			}
		}
	}

	/**
	 * Constructor.
	 */
	public BlockCrate() {
		super(Material.wood);
		setHardness(0.5F);
		setResistance(5F);
		setDefaultState(blockState.getBaseState().withProperty(VARIANT,
				Type.CLOSED));
		this.setStepSound(soundTypeWood);
		setCreativeTab(WSMPmain.tabWSMPBlocks);
	}

	@Override
	public int damageDropped(final IBlockState state) {
		final Type type = (Type) state.getValue(VARIANT);
		return type.getMetadata();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(final Item itemIn, final CreativeTabs tab,
			final List list) {
		for (Type type : Type.values()) {
			final int metadata = type.getMetadata();
			final ItemStack stack = new ItemStack(itemIn, 1, metadata);
			list.add(stack);
		}
	}

	@Override
	public IBlockState getStateFromMeta(final int meta) {
		final IBlockState defaultState = getDefaultState();
		final Type type = Type.byMetadata(meta);
		return defaultState.withProperty(VARIANT, type);
	}

	@Override
	public int getMetaFromState(final IBlockState state) {
		final Type type = (Type) state.getValue(VARIANT);
		return type.getMetadata();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { VARIANT });
	}

	@Override
	public IBlockState onBlockPlaced(final World worldIn, final BlockPos pos,
			final EnumFacing blockFaceClickedOn, final float hitX,
			final float hitY, final float hitZ, final int meta,
			final EntityLivingBase placer) {
		final IBlockState defaultState = getDefaultState();
		final Type type = Type.byMetadata(meta);
		return defaultState.withProperty(VARIANT, type);
	}

	/**
	 * Registers all crates with Forge.
	 */
	public static void register() {
		final BlockCrate blockCrate = new BlockCrate();
		blockCrate.setUnlocalizedName(NAME);
		GameRegistry.registerBlock(blockCrate, ItemBlockCrate.class, NAME);
	}
}
