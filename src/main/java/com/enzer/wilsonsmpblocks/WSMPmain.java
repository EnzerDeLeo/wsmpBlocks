package com.enzer.wilsonsmpblocks;

import com.enzer.wilsonsmpblocks.blocks.BlockBrickExtra;
import com.enzer.wilsonsmpblocks.blocks.BlockBrickExtraSlab;
import com.enzer.wilsonsmpblocks.blocks.BlockClayBrickFancy;
import com.enzer.wilsonsmpblocks.blocks.BlockClayBrickPainted;
import com.enzer.wilsonsmpblocks.blocks.BlockClayBrickPlain;
import com.enzer.wilsonsmpblocks.blocks.BlockCrate;
import com.enzer.wilsonsmpblocks.blocks.BlockDaubWattle;
import com.enzer.wilsonsmpblocks.blocks.BlockDaubWattleColor;
import com.enzer.wilsonsmpblocks.blocks.BlockDoubleBrickExtraSlab;
import com.enzer.wilsonsmpblocks.blocks.BlockDoubleObsidianBrickSlab;
import com.enzer.wilsonsmpblocks.blocks.BlockDoubleSandstoneBrickSlab;
import com.enzer.wilsonsmpblocks.blocks.BlockGlowstoneColor;
import com.enzer.wilsonsmpblocks.blocks.BlockHalfBrickExtraSlab;
import com.enzer.wilsonsmpblocks.blocks.BlockHalfObsidianBrickSlab;
import com.enzer.wilsonsmpblocks.blocks.BlockHalfSandstoneBrickSlab;
import com.enzer.wilsonsmpblocks.blocks.BlockLamp;
import com.enzer.wilsonsmpblocks.blocks.BlockLantern;
import com.enzer.wilsonsmpblocks.blocks.BlockLapis;
import com.enzer.wilsonsmpblocks.blocks.BlockLogRope;
import com.enzer.wilsonsmpblocks.blocks.BlockMetalCube;
import com.enzer.wilsonsmpblocks.blocks.BlockNether;
import com.enzer.wilsonsmpblocks.blocks.BlockObsidian;
import com.enzer.wilsonsmpblocks.blocks.BlockObsidianBrickSlab;
import com.enzer.wilsonsmpblocks.blocks.BlockObsidianBrickStairs;
import com.enzer.wilsonsmpblocks.blocks.BlockPavedStone;
import com.enzer.wilsonsmpblocks.blocks.BlockPortcullis;
import com.enzer.wilsonsmpblocks.blocks.BlockRope;
import com.enzer.wilsonsmpblocks.blocks.BlockRopeTop;
import com.enzer.wilsonsmpblocks.blocks.BlockSandVar;
import com.enzer.wilsonsmpblocks.blocks.BlockSandstoneBrick;
import com.enzer.wilsonsmpblocks.blocks.BlockSandstoneBrickSlab;
import com.enzer.wilsonsmpblocks.blocks.BlockShelves;
import com.enzer.wilsonsmpblocks.blocks.BlockSteeringWheel;
import com.enzer.wilsonsmpblocks.items.ItemBlockBrickExtraSlab;
import com.enzer.wilsonsmpblocks.items.ItemBlockObsidianBrickSlab;
import com.enzer.wilsonsmpblocks.items.ItemBlockSandstoneBrickSlab;
import com.enzer.wilsonsmpblocks.items.ItemList;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * Main mod class.
 * 
 * @author Enzer
 * @author Tuxide
 * @version %I%, %G%
 * @since 1.8
 */
@SuppressWarnings("javadoc")
@Mod(modid = WSMPmain.MODID, version = WSMPmain.VERSION, name = WSMPmain.NAME)
public class WSMPmain
{
	public static final String MODID = "wilsonsmpblocks";
	public static final String VERSION = "Alpha 1.0";
	public static final String NAME = "WilsonSMP: Wilson's Gay Edition";
	public static final String SERVER_PROXY = "com.enzer.wilsonsmpblocks.ServerProxy";
	public static final String CLIENT_PROXY = "com.enzer.wilsonsmpblocks.ClientProxy";

	private File config;
	// need this since the directory is not available in postInit
	private String configDir;

	@Instance(WSMPmain.MODID)
	public static WSMPmain instance;

	@SidedProxy(clientSide = WSMPmain.CLIENT_PROXY, serverSide = WSMPmain.SERVER_PROXY)
	private static ServerProxy proxy;

	public static Logger log;

	public static final CreativeTabs tabWSMPBlocks = new CreativeTabs("WSMPDecorativeBlocks")
	{
		@Override
		@SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(Blocks.stonebrick);
		}
	};

	public static final CreativeTabs tabWSMPItems = new CreativeTabs("WSMPItems")
	{
		@Override
		@SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
		public Item getTabIconItem()
		{
			return Items.stick;
		}
	};

	/*
	 * public static CreativeTabs tabBetterStorage;
	 */

	/**
	 * @param event
	 *            Pre-initialization event object
	 */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ItemList.mainRegistry();
		BlockCrate.register();
		BlockDaubWattle.register();
		BlockDaubWattleColor.register();
		BlockClayBrickPlain.register();
		BlockClayBrickFancy.register();
		BlockClayBrickPainted.register();
		BlockGlowstoneColor.register();
		BlockLantern.register();
		BlockLapis.register();
		BlockObsidian.register();
		BlockSandstoneBrick.register();
		BlockMetalCube.register();
		BlockSandVar.register();
		BlockShelves.register();
		BlockBrickExtra.register();
		BlockPavedStone.register();
		BlockObsidianBrickStairs.register();
		BlockLogRope.register();
		BlockRope.register();
		BlockRopeTop.register();
		BlockNether.register();
		BlockSteeringWheel.register();
		BlockPortcullis.register();
		BlockLamp.register();
		
		BlockSandstoneBrickSlab slab = new BlockHalfSandstoneBrickSlab(Material.rock);
		BlockSandstoneBrickSlab doubleSlab = new BlockDoubleSandstoneBrickSlab(Material.rock);
		GameRegistry.registerBlock(slab, ItemBlockSandstoneBrickSlab.class, BlockSandstoneBrickSlab.NAME, slab, doubleSlab, false);
		GameRegistry.registerBlock(doubleSlab, ItemBlockSandstoneBrickSlab.class, BlockSandstoneBrickSlab.NAME + "_double", slab, doubleSlab, true);
		
		BlockBrickExtraSlab brickExtraSlab = new BlockHalfBrickExtraSlab(Material.rock);
		BlockBrickExtraSlab brickExtraDoubleSlab = new BlockDoubleBrickExtraSlab(Material.rock);
		GameRegistry.registerBlock(brickExtraSlab, ItemBlockBrickExtraSlab.class, BlockBrickExtraSlab.NAME, brickExtraSlab, brickExtraDoubleSlab, false);
		GameRegistry.registerBlock(brickExtraDoubleSlab, ItemBlockBrickExtraSlab.class, BlockBrickExtraSlab.NAME + "_double", brickExtraSlab, brickExtraDoubleSlab, true);
		
		BlockObsidianBrickSlab obsidianSlab = new BlockHalfObsidianBrickSlab(Material.rock);
		BlockObsidianBrickSlab obsidianDoubleSlab = new BlockDoubleObsidianBrickSlab(Material.rock);
		GameRegistry.registerBlock(obsidianSlab, ItemBlockObsidianBrickSlab.class, obsidianSlab.getID(), obsidianSlab, obsidianDoubleSlab, false);
		GameRegistry.registerBlock(obsidianDoubleSlab, ItemBlockObsidianBrickSlab.class, obsidianDoubleSlab.getID(), obsidianSlab, obsidianDoubleSlab, true);
	}

	/**
	 * @param event
	 *            Unused, needed for Forge.
	 */
	/*
	 * NOTE addRecipe() expects char not String, thus we're suppressing boxing
	 */
	@SuppressWarnings("boxing")
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRender();
		proxy.initialize();
	}

	/**
	 * @param event
	 *            Unused, needed for Forge.
	 */
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}

}
