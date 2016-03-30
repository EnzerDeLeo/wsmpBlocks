package com.enzer.wilsonsmpblocks.items;

import com.enzer.wilsonsmpblocks.WSMPmain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

@SuppressWarnings("javadoc")
public class ItemList {
	private static Item dw_frame_empty;
	private static Item dw_frame_left;
	private static Item dw_frame_right;
	private static Item dw_frame_x;
	private static Item frame_insert_left;
	private static Item frame_insert_right;
	private static Item frame_insert_x;
	private static Item fletching;
	private static Item flint_arrow_head;
	private static Item arrow_shaft;
	private static Item dirt_clod;
	private static Item alchemical_part_1;
	private static Item alchemical_part_2;
	private static Item alchemical_part_3;
	private static Item sandpaper;

	private ItemList() {
		/*
		 * This block intentionally left blank.
		 */
	}

	public static void mainRegistry() {
		itemsInit();
		itemRegister();
	}

	public static void itemsInit() {
		dw_frame_empty = new Item().setCreativeTab(WSMPmain.tabWSMPItems)
				.setUnlocalizedName("dw_frame_empty");
		dw_frame_left = new Item().setCreativeTab(WSMPmain.tabWSMPItems)
				.setUnlocalizedName("dw_frame_left");
		dw_frame_right = new Item().setCreativeTab(WSMPmain.tabWSMPItems)
				.setUnlocalizedName("dw_frame_right");
		dw_frame_x = new Item().setCreativeTab(WSMPmain.tabWSMPItems)
				.setUnlocalizedName("dw_frame_x");
		frame_insert_left = new Item().setCreativeTab(WSMPmain.tabWSMPItems)
				.setUnlocalizedName("frame_insert_left");
		frame_insert_right = new Item().setCreativeTab(WSMPmain.tabWSMPItems)
				.setUnlocalizedName("frame_insert_right");
		frame_insert_x = new Item().setCreativeTab(WSMPmain.tabWSMPItems)
				.setUnlocalizedName("frame_insert_x");
		fletching = new Item().setCreativeTab(WSMPmain.tabWSMPItems)
				.setUnlocalizedName("fletching");
		flint_arrow_head = new Item().setCreativeTab(WSMPmain.tabWSMPItems)
				.setUnlocalizedName("flint_arrow_head");
		arrow_shaft = new Item().setCreativeTab(WSMPmain.tabWSMPItems)
				.setUnlocalizedName("arrow_shaft");
		dirt_clod = new Item().setCreativeTab(WSMPmain.tabWSMPItems)
				.setUnlocalizedName("dirt_clod");
		alchemical_part_1 = new Item().setCreativeTab(WSMPmain.tabWSMPItems)
				.setUnlocalizedName("alchemical_part_1");
		alchemical_part_2 = new Item().setCreativeTab(WSMPmain.tabWSMPItems)
				.setUnlocalizedName("alchemical_part_2");
		alchemical_part_3 = new Item().setCreativeTab(WSMPmain.tabWSMPItems)
				.setUnlocalizedName("alchemical_part_3");
		sandpaper = new Item().setCreativeTab(WSMPmain.tabWSMPItems)
				.setUnlocalizedName("sandpaper");
	}

	public static void itemRegister() {
		GameRegistry.registerItem(dw_frame_empty, dw_frame_empty
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(dw_frame_left, dw_frame_left
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(dw_frame_right, dw_frame_right
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(dw_frame_x, dw_frame_x.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(frame_insert_left, frame_insert_left
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(frame_insert_right, frame_insert_right
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(frame_insert_x, frame_insert_x
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fletching, fletching.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(flint_arrow_head, flint_arrow_head
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(arrow_shaft, arrow_shaft.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(dirt_clod, dirt_clod.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(alchemical_part_1, alchemical_part_1
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(alchemical_part_2, alchemical_part_2
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(alchemical_part_3, alchemical_part_3
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(sandpaper, sandpaper.getUnlocalizedName()
				.substring(5));
	}

	public static void registerRenders() {
		registerRender(dw_frame_empty);
		registerRender(dw_frame_left);
		registerRender(dw_frame_right);
		registerRender(dw_frame_x);
		registerRender(frame_insert_left);
		registerRender(frame_insert_right);
		registerRender(frame_insert_x);
		registerRender(fletching);
		registerRender(flint_arrow_head);
		registerRender(arrow_shaft);
		registerRender(dirt_clod);
		registerRender(alchemical_part_1);
		registerRender(alchemical_part_2);
		registerRender(alchemical_part_3);
		registerRender(sandpaper);
	}

	public static void registerRender(Item item) {
		Minecraft
				.getMinecraft()
				.getRenderItem()
				.getItemModelMesher()
				.register(
						item,
						0,
						new ModelResourceLocation(WSMPmain.MODID + ":"
								+ item.getUnlocalizedName().substring(5),
								"inventory"));
	}

}
