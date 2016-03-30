package com.enzer.wilsonsmpblocks;

import com.enzer.wilsonsmpblocks.blocks.BlockBrickExtra;
import com.enzer.wilsonsmpblocks.blocks.BlockBrickExtraSlab;
import com.enzer.wilsonsmpblocks.blocks.BlockBrickExtraStairs;
import com.enzer.wilsonsmpblocks.blocks.BlockClayBrickFancy;
import com.enzer.wilsonsmpblocks.blocks.BlockClayBrickPainted;
import com.enzer.wilsonsmpblocks.blocks.BlockClayBrickPlain;
import com.enzer.wilsonsmpblocks.blocks.BlockCrate;
import com.enzer.wilsonsmpblocks.blocks.BlockDaubWattle;
import com.enzer.wilsonsmpblocks.blocks.BlockDaubWattleColor;
import com.enzer.wilsonsmpblocks.blocks.BlockGlowstoneColor;
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
import com.enzer.wilsonsmpblocks.blocks.BlockSandstoneBrickStairs;
import com.enzer.wilsonsmpblocks.blocks.BlockShelves;
import com.enzer.wilsonsmpblocks.blocks.BlockSteeringWheel;
import com.enzer.wilsonsmpblocks.blocks.HasMetadata;
import com.enzer.wilsonsmpblocks.items.ItemList;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends ServerProxy
{
	@Override
	public void initialize()
	{
		super.initialize();
	}

	@Override
	public void registerRender()
	{
		ItemList.registerRenders();

		registerRenders(BlockCrate.NAME, BlockCrate.Type.values());
		registerRenders(BlockDaubWattle.NAME, BlockDaubWattle.Type.values());
		registerRenders(BlockDaubWattleColor.NAME, BlockDaubWattleColor.Type.values());
		registerRenders(BlockClayBrickPlain.NAME, BlockClayBrickPlain.Type.values());
		registerRenders(BlockClayBrickFancy.NAME, BlockClayBrickFancy.Type.values());
		registerRenders(BlockClayBrickPainted.NAME, BlockClayBrickPainted.Type.values());
		registerRenders(BlockGlowstoneColor.NAME, BlockGlowstoneColor.Type.values());
		registerRenders(BlockLantern.NAME, BlockLantern.Type.values());
		registerRenders(BlockLapis.NAME, BlockLapis.Type.values());
		registerRenders(BlockObsidian.NAME, BlockObsidian.Type.values());
		registerRenders(BlockSandstoneBrick.NAME, BlockSandstoneBrick.Type.values());
		registerRenders(BlockSandstoneBrickSlab.NAME, BlockSandstoneBrick.Type.values());
		registerRenders(BlockMetalCube.NAME, BlockMetalCube.Type.values());
		registerRenders(BlockSandVar.NAME, BlockSandVar.Type.values());
		registerRenders(BlockShelves.NAME, BlockShelves.Type.values());
		registerRenders(BlockBrickExtra.NAME, BlockBrickExtra.Type.values());
		registerRenders(BlockBrickExtraSlab.NAME, BlockBrickExtra.Type.values());
		registerRenders(BlockPavedStone.NAME, BlockPavedStone.Type.values());
		registerRenders(BlockLogRope.NAME, BlockLogRope.Type.values());
		registerRenders(BlockRope.NAME, BlockRope.Type.values());
		registerRenders(BlockRopeTop.NAME, BlockRopeTop.Type.values());
		registerRenders(BlockNether.NAME, BlockNether.Type.values());
		registerRenders(BlockSteeringWheel.NAME, BlockSteeringWheel.Type.values());
		registerRenders(BlockPortcullis.NAME, BlockPortcullis.Type.values());
		registerSandstoneBrickStairItemRenders();
		registerBrickExtraStairItemRenders();
		registerObsidianBrickSlabItemRender();
		registerObsidianBrickStairsItemRender();
		registerRenders(BlockLamp.NAME, BlockLamp.Type.values());
	}

	public void registerRenders(final String name, final HasMetadata[] types)
	{
		final String[] names = new String[types.length];

		int i = 0;
		for (final HasMetadata type : types)
		{
			names[i++] = WSMPmain.MODID + ":" + name + "_" + type.getName();
		}

		final Item item = GameRegistry.findItem(WSMPmain.MODID, name);
		ModelBakery.addVariantName(item, names);

		for (final HasMetadata type : types)
		{
			final ModelResourceLocation loc = new ModelResourceLocation(WSMPmain.MODID + ":" + name + "_" + type.getName(), "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, type.getMetadata(), loc);
		}
	}

	public void registerSandstoneBrickStairItemRenders()
	{
		for (BlockSandstoneBrick.Type type : BlockSandstoneBrick.Type.values())
		{
			String name = BlockSandstoneBrickStairs.NAME + "." + type.name().toLowerCase();
			final Item item = GameRegistry.findItem(WSMPmain.MODID, name);
			final ModelResourceLocation loc = new ModelResourceLocation(WSMPmain.MODID + ":" + name, "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, loc);
		}
	}
	
	public void registerBrickExtraStairItemRenders()
	{
		for (BlockBrickExtra.Type type : BlockBrickExtra.Type.values())
		{
			String name = BlockBrickExtraStairs.NAME + "." + type.name().toLowerCase();
			final Item item = GameRegistry.findItem(WSMPmain.MODID, name);
			final ModelResourceLocation loc = new ModelResourceLocation(WSMPmain.MODID + ":" + name, "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, loc);
		}
	}

	public void registerObsidianBrickSlabItemRender()
	{
		String name = BlockObsidianBrickSlab.NAME;
		final Item item = GameRegistry.findItem(WSMPmain.MODID, name);
		final ModelResourceLocation loc = new ModelResourceLocation(WSMPmain.MODID + ":" + name, "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, loc);
	}
	
	public void registerObsidianBrickStairsItemRender()
	{
		String name = BlockObsidianBrickStairs.NAME;
		final Item item = GameRegistry.findItem(WSMPmain.MODID, name);
		final ModelResourceLocation loc = new ModelResourceLocation(WSMPmain.MODID + ":" + name, "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, loc);
	}

	@Override
	public void registerNonRenderingProperties(final Block block, final IProperty[] nonRenderingProperties)
	{
		final StateMap.Builder builder = new StateMap.Builder().ignore(nonRenderingProperties);
		final IStateMapper customMapper = builder.build();
		ModelLoader.setCustomStateMapper(block, customMapper);
	}

	public void registerTileEntityRenders(final String name, final HasMetadata[] types)
	{
		final String[] names = new String[types.length];

		int i = 0;
		for (final HasMetadata type : types)
		{
			names[i++] = WSMPmain.MODID + ":" + name + "_" + type.getName();
		}

		final Item item = GameRegistry.findItem(WSMPmain.MODID, name);

		ModelBakery.addVariantName(item, names);

		for (final HasMetadata type : types)
		{
			final ModelResourceLocation loc = new ModelResourceLocation(WSMPmain.MODID + ":" + name + "_" + type.getName(), "inventory");

			final RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			renderItem.getItemModelMesher().register(item, type.getMetadata(), loc);
		}
	}
}
