package com.example.featherduskmod.core.enums;

import java.util.function.Supplier; 
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import com.example.featherduskmod.core.init.ItemInit;

//=================================================================
// WandMaterial.java			Author: Vibha Raghu
//
// Creates the Red Jewel material for Wand weapon
//=================================================================

//-----------------------------------------------------------------
// Enum makes variable representation a group of constants
//-----------------------------------------------------------------

public enum WandMaterial implements IItemTier{
	RED_JEWEL(1, 140, 1F, 1F, 5, () -> Ingredient.of(ItemInit.RED_JEWEL_INGOT.get()));
	
	private final Supplier<Ingredient> repairmaterial; //repair material type
    private final int enchantability; //how enchantable it is
    private final float attackDamage; //how much base damage
    private final float efficiency; //how efficient the material is
    private final int maxUses; //maximum uses 
    private final int harvestLevel; //harvest level
    
    WandMaterial(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairmaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairmaterial = repairmaterial;
    }

	@Override
	public int getUses() {
		return this.maxUses;
	}

	@Override
	public float getSpeed() {
		return this.efficiency;
	}

	@Override
	public float getAttackDamageBonus() {
		return this.attackDamage;
	}

	@Override
	public int getLevel() {
		return this.harvestLevel;
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairmaterial.get();
	}
	

}
