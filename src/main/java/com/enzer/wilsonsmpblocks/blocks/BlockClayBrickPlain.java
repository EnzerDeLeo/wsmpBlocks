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
import com.enzer.wilsonsmpblocks.items.ItemBlockClayBrickPlain;

/**
 * Block representing a plain clay brick.
 * 
 * @author Enzer
 * @author Tuxide
 * @version %I%, %G%
 * @since 1.8
 */
public class BlockClayBrickPlain extends Block {
	@SuppressWarnings("javadoc")
	public static final String NAME = "claybrickplain";
	private static final PropertyEnum VARIANT = PropertyEnum.create("variant",
			Type.class);

	/**
	 * Types of plain clay brick.
	 * 
	 * @author Tuxide
	 *
	 */
	@SuppressWarnings("javadoc")
	public static enum Type implements HasMetadata {
		BLACK(0, "black"), BLUE(1, "blue"), BROWN(2, "brown"), CYAN(3, "cyan"), GRAY(
				4, "gray"), GREEN(5, "green"), LIGHTBLUE(6, "lightblue"), LIGHTGRAY(
				7, "lightgray"), LIME(8, "lime"), MAGENTA(9, "magenta"), ORANGE(
				10, "orange"), PINK(11, "pink"), PURPLE(12, "purple"), RED(13,
				"red"), WHITE(14, "white"), YELLOW(15, "yellow");

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
	public BlockClayBrickPlain() {
		super(Material.rock);
		setHardness(1.5F);
		setResistance(5F);
		setDefaultState(blockState.getBaseState().withProperty(VARIANT,
				Type.BLACK));
		this.setHarvestLevel("pickaxe", 1);
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
	 * Registers all plain clay bricks with Forge.
	 */
	public static void register() {
		final BlockClayBrickPlain blockClayBrickPlain = new BlockClayBrickPlain();
		blockClayBrickPlain.setUnlocalizedName(NAME);
		GameRegistry.registerBlock(blockClayBrickPlain,
				ItemBlockClayBrickPlain.class, NAME);
	}
}
