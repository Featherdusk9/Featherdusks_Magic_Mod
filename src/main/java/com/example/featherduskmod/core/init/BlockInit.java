package com.example.featherduskmod.core.init;

import com.example.featherduskmod.FeatherduskMod;  
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//====================================================
//BlockInit.java		Author: Vibha Raghu
//
//Contains all the block object initializations. 
//=====================================================


public class BlockInit {
	
	// All blocks are registered to the deferred registry
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			FeatherduskMod.MOD_ID);
	
	//All blocks are registered as a registry object and given properties 
	public static final RegistryObject<Block> JEWELED_ORE = BLOCKS.register("jeweled_ore", 
			() -> new Block(AbstractBlock.Properties
					.of(Material.STONE)
					.strength(15f, 3f) //hardness and resistance (how long it takes to break)
					.harvestTool(ToolType.PICKAXE) //tool type required to break 
					.harvestLevel(2) //level 2 requires iron level pickaxe to break
					.sound(SoundType.METAL) //sound when breaking is similar to that of metal
					.lightLevel((state) -> { 
						return 5;
					}) //Emits light level 5 out of 15.
					.requiresCorrectToolForDrops())); //requires the correct tool for the 
													  //block to drop items otherwise the block will not drop its given items
	
}
