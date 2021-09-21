package com.example.featherduskmod.core.enums;

import java.util.function.Supplier;  
import com.example.featherduskmod.FeatherduskMod;
import com.example.featherduskmod.core.init.ItemInit;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

//=================================================================
//	ArmorMaterial.java			Author: Vibha Raghu
//
//	Creates the Green Jewel material for armor along with armor
//  states and properties.
//=================================================================

//-----------------------------------------------------------------
// Enum makes variable representation a group of constants
//-----------------------------------------------------------------


public enum ArmorMaterial implements IArmorMaterial{
	GREEN_JEWEL("green_jewel", 10, new int[]{3, 6, 8, 3}, 40, SoundEvents.ARMOR_EQUIP_GOLD, 0.0F, 0.4F, () -> Ingredient.of(ItemInit.GREEN_JEWEL.get())),
	ENHANCED_GREEN_JEWEL("enhanced_green_jewel", 10, new int[]{3, 6, 8, 3}, 40, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.4F, () -> Ingredient.of(ItemInit.YELLOW_JEWEL.get()));
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11}; //generic armor protection/damage values
    private final String name;
    private final int maxDamageFactor;
    private final int[] defenseForSlotAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairMaterial;
    private final LazyValue<Ingredient> ingredient;
   
	
	//-----------------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------------

	ArmorMaterial(String name, int maxDamageFactor, int[] defenseForSlot, int enchantability, 
			SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial)
	{
		this.name = name; //name of armor material
		this.maxDamageFactor = maxDamageFactor; //determines durability
		this.defenseForSlotAmountArray = defenseForSlot; //amount of defense
		this.enchantability = enchantability; //how easy it is to enchant
		this.soundEvent = sound; //sound type
		this.toughness = toughness; //mitigate power of strong attacks
		this.knockbackResistance = knockbackResistance; //prevents knockback
		this.repairMaterial = new LazyValue<>(repairMaterial);//material to repair
		this.ingredient = new LazyValue<>(repairMaterial);// ingredient to repair
	}
	

	@Override
	public int getDurabilityForSlot(EquipmentSlotType p_200896_1_) {
		return MAX_DAMAGE_ARRAY[p_200896_1_.getIndex()] * this.maxDamageFactor;//multiplier 
	}

	@Override
	public int getDefenseForSlot(EquipmentSlotType p_200902_1_) {
		return this.defenseForSlotAmountArray[p_200902_1_.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.soundEvent;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairMaterial.get();
	}

	@Override
	public String getName() {
		return FeatherduskMod.MOD_ID + ":" + this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
	
	public Ingredient getIngredient() {
        return this.ingredient.get();
    }

    public ArmorMaterial getType() {
        return this;
    }

}
