package com.example.featherduskmod.core.init;

import com.example.featherduskmod.FeatherduskMod;  
import com.example.featherduskmod.common.items.MagicArmor;
import com.example.featherduskmod.common.items.Wand;
import com.example.featherduskmod.core.enums.ArmorMaterial;
import com.example.featherduskmod.core.enums.WandMaterial;

import net.minecraft.inventory.EquipmentSlotType;
//import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
//import net.minecraft.item.Item.Properties;
//import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//=================================================================================
// ItemInit.java		Author: Vibha Raghu
//
// Contains all the item object initializations. 
//=================================================================================

public class ItemInit {
	
	//All items must be registered to the Deferred Registry
	public static final DeferredRegister<Item> ITEMS = DeferredRegister
			.create(ForgeRegistries.ITEMS, FeatherduskMod.MOD_ID);
	
	//Every block that drops an item must be also registered as a BlockItem 
		public static final RegistryObject<BlockItem> JEWELED_ORE = ITEMS.register("jeweled_ore", 
				() -> new BlockItem(BlockInit.JEWELED_ORE.get(), new Item.Properties()
						.tab(ItemGroup.TAB_BUILDING_BLOCKS)));
	
	//Each new item must be registered as an object and given 
		
	//Red Jewel Items
	public static final RegistryObject<Item> RED_JEWEL = ITEMS.register("red_jewel", 
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
	
	public static final RegistryObject<Item> RED_JEWEL_INGOT = ITEMS.register("red_jewel_ingot", 
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
	
	public static final RegistryObject<Wand> WAND = ITEMS.register("wand",
			() -> new Wand(WandMaterial.RED_JEWEL, 1, -2F, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
	
	//Blue Jewel Items
	public static final RegistryObject<Item> BLUE_JEWEL = ITEMS.register("blue_jewel", 
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
	
	public static final RegistryObject<Item> BLUE_POWDER = ITEMS.register("blue_powder", 
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder()
					.effect(() -> new EffectInstance(Effects.REGENERATION, 100, 0), 0.67f)
					.fast().nutrition(0).saturationMod(0.1f).alwaysEat().build())));
	
	public static final RegistryObject<Item> BLUE_POWDERED_APPLE = ITEMS.register("blue_powdered_apple", 
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder()
					.effect(() -> new EffectInstance(Effects.REGENERATION, 100, 0), 0.67f)
					.nutrition(4).saturationMod(0.3f).alwaysEat().build())));
	
	public static final RegistryObject<Item> BLUE_POWDERED_COOKIE = ITEMS.register("blue_powdered_cookie", 
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder()
					.effect(() -> new EffectInstance(Effects.REGENERATION, 100, 0), 0.67f)
					.nutrition(2).saturationMod(0.1f).alwaysEat().build())));
	
	public static final RegistryObject<Item> BLUE_POWDERED_PIE = ITEMS.register("blue_powdered_pie", 
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder()
					.effect(() -> new EffectInstance(Effects.REGENERATION, 100, 0), 0.67f)
					.nutrition(8).saturationMod(0.3f).alwaysEat().build())));
	
	public static final RegistryObject<Item> BLUE_POWDERED_DRIED_KELP = ITEMS.register("blue_powdered_dried_kelp", 
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder()
					.effect(() -> new EffectInstance(Effects.REGENERATION, 100, 0), 0.67f)
					.nutrition(1).saturationMod(0.3f).alwaysEat().build())));


	//Yellow Jewel Items (excluding potions)
	public static final RegistryObject<Item> YELLOW_JEWEL = ITEMS.register("yellow_jewel", 
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
	
	//Green Jewel Items
	public static final RegistryObject<Item> GREEN_JEWEL = ITEMS.register("green_jewel", 
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
	
	
	public static final RegistryObject<MagicArmor> GREEN_JEWEL_HELMET = ITEMS.register("green_jewel_helmet",
			() -> new MagicArmor(ArmorMaterial.GREEN_JEWEL, EquipmentSlotType.HEAD, new Item.Properties().tab(ItemGroup.TAB_COMBAT), false));
	
	public static final RegistryObject<MagicArmor> GREEN_JEWEL_CHESTPLATE = ITEMS.register("green_jewel_chestplate",
			() -> new MagicArmor(ArmorMaterial.GREEN_JEWEL, EquipmentSlotType.CHEST, new Item.Properties().tab(ItemGroup.TAB_COMBAT), false));
					
	public static final RegistryObject<MagicArmor> GREEN_JEWEL_LEGGINGS = ITEMS.register("green_jewel_leggings",
			() -> new MagicArmor(ArmorMaterial.GREEN_JEWEL, EquipmentSlotType.LEGS, new Item.Properties().tab(ItemGroup.TAB_COMBAT), false));
			
	public static final RegistryObject<MagicArmor> GREEN_JEWEL_BOOTS = ITEMS.register("green_jewel_boots",
			() -> new MagicArmor(ArmorMaterial.GREEN_JEWEL, EquipmentSlotType.FEET, new Item.Properties().tab(ItemGroup.TAB_COMBAT), false));
	
			
	public static final RegistryObject<MagicArmor> ENHANCED_GREEN_JEWEL_HELMET = ITEMS.register("enhanced_green_jewel_helmet",
			() -> new MagicArmor(ArmorMaterial.ENHANCED_GREEN_JEWEL, EquipmentSlotType.HEAD, new Item.Properties().tab(ItemGroup.TAB_COMBAT), true));
	
	public static final RegistryObject<MagicArmor> ENHANCED_GREEN_JEWEL_CHESTPLATE = ITEMS.register("enhanced_green_jewel_chestplate",
			() -> new MagicArmor(ArmorMaterial.ENHANCED_GREEN_JEWEL, EquipmentSlotType.CHEST, new Item.Properties().tab(ItemGroup.TAB_COMBAT), true));
					
	public static final RegistryObject<MagicArmor> ENHANCED_GREEN_JEWEL_LEGGINGS = ITEMS.register("enhanced_green_jewel_leggings",
			() -> new MagicArmor(ArmorMaterial.ENHANCED_GREEN_JEWEL, EquipmentSlotType.LEGS, new Item.Properties().tab(ItemGroup.TAB_COMBAT), true));
			
	public static final RegistryObject<MagicArmor> ENHANCED_GREEN_JEWEL_BOOTS = ITEMS.register("enhanced_green_jewel_boots",
			() -> new MagicArmor(ArmorMaterial.ENHANCED_GREEN_JEWEL, EquipmentSlotType.FEET, new Item.Properties().tab(ItemGroup.TAB_COMBAT), true));
	

}
