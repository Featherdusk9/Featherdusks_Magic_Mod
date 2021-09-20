package com.example.featherduskmod.core.init;

import com.example.featherduskmod.FeatherduskMod; 
import com.example.featherduskmod.common.potions.YellowJewelEffect;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//=================================================================================
//	PotionInit.java				Author: Vibha Raghu
//
//	Initializes Potions and Effects
//=================================================================================

public class PotionInit {
	
	//Creates a Deferred Registry. Takes the potions and effects and makes them 
	//known to the game
	
	//Deferred Registry is newer way to register items. Makes use of static initializers.
	//Maintains a list of suppliers for entries and registers from those suppliers during the
	//RegistryEvent.Register event. 
	public static final DeferredRegister<Effect> EFFECTS = DeferredRegister
			.create(ForgeRegistries.POTIONS, FeatherduskMod.MOD_ID); //Deferred Register for Effects
	
	public static final DeferredRegister<Potion> POTIONS = DeferredRegister
			.create(ForgeRegistries.POTION_TYPES, FeatherduskMod.MOD_ID);//Deferred Register for Potions
	
	public static final RegistryObject<Effect> YELLOW_JEWEL_EFFECT = EFFECTS.register("yellow_jewel_effect",
			() -> new YellowJewelEffect(EffectType.HARMFUL, 0xf7ce00)); //Harmful Effect & Color Code for the potion/effect
	
	public static final RegistryObject<Potion> YELLOW_JEWEL_POTION = POTIONS.register("yellow_jewel_effect",
			() -> new Potion(new EffectInstance(YELLOW_JEWEL_EFFECT.get(), 1200, 0))); //1200 ticks
	
	public static final RegistryObject<Potion> LONG_YELLOW_JEWEL_POTION = POTIONS.register("long_yellow_jewel_effect",
			() -> new Potion(new EffectInstance(YELLOW_JEWEL_EFFECT.get(), 2400, 0))); //2400 ticks
	  
	public static final RegistryObject<Potion> STRONG_YELLOW_JEWEL_POTION = POTIONS.register("strong_yellow_jewel_effect",
			() -> new Potion(new EffectInstance(YELLOW_JEWEL_EFFECT.get(), 600, 1))); //600 ticks and level 1
	
	//adds potion recipe to create Yellow Jewel Potion, Long Yellow Jewel Potion, and Strong Yellow Jewel Potion
	public static void addPotionRecipe() 
	{
		BrewingRecipeRegistry.addRecipe(new MagicBrewingRecipe(Potions.AWKWARD, ItemInit.YELLOW_JEWEL.get(), YELLOW_JEWEL_POTION.get()));
		BrewingRecipeRegistry.addRecipe(new MagicBrewingRecipe(YELLOW_JEWEL_POTION.get(), Items.REDSTONE, LONG_YELLOW_JEWEL_POTION.get()));
		BrewingRecipeRegistry.addRecipe(new MagicBrewingRecipe(YELLOW_JEWEL_POTION.get(), Items.GLOWSTONE_DUST, STRONG_YELLOW_JEWEL_POTION.get()));
	}
	
	//Creates modified Brewing Recipe class 
	private static class MagicBrewingRecipe implements IBrewingRecipe {

		private final Potion bottleInput;
		private final Item itemInput;
		private final ItemStack output;
		
		public MagicBrewingRecipe(Potion bottleInput, Item itemInput, Potion output)
		{
			this.bottleInput = bottleInput;
			this.itemInput = itemInput;
			this.output = PotionUtils.setPotion(new ItemStack(Items.POTION), output);
		}
		
	
		@Override
		public boolean isInput(ItemStack input) {
			return PotionUtils.getPotion(input).equals(this.bottleInput);
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem().equals(this.itemInput);
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if(isInput(input) && isIngredient(ingredient))
			{
				return this.output.copy();
			}
			else 
			{
				return ItemStack.EMPTY;
			}
		}
		
	}
	
}

