package com.enzer.wilsonsmpblocks;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ServerProxy {
	public void registerRender() {
		/*
		 * This block intentionally left blank.
		 */
	}

	public void initialize() {
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
	}

	public void registerNonRenderingProperties(Block block,
			IProperty[] nonRenderingProperties) {
		/*
		 * This block intentionally left blank.
		 */
	}
}
