package com.example.featherduskmod.common.items;

import java.util.List;

import org.lwjgl.glfw.GLFW;


import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

//===================================================
//	MagicArmor.java		Author:Vibha Raghu
//
//	Creates new child Armor class for special Armor
//===================================================
public class MagicArmor extends ArmorItem{

	private EquipmentSlotType slot;
	private boolean enhanced;
	
	public MagicArmor(IArmorMaterial p_i48534_1_, EquipmentSlotType p_i48534_2_, Properties p_i48534_3_, boolean enhanced) {
		super(p_i48534_1_, p_i48534_2_, p_i48534_3_);
		this.enhanced = enhanced;
		slot = p_i48534_2_;
		//Material, Slot, item property or tab, enhanced attribute boolean
	}
	
	//Adds extra information when pressing shift
	public void appendHoverText(ItemStack p_77624_1_, World p_77624_2_, List<ITextComponent> p_77624_3_,
			ITooltipFlag p_77624_4_) {
		super.appendHoverText(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
		
		//appends level 
		String level;
		if(enhanced == false)
			level = "I";
		else
			level = "II";
		//if left shift is pressed
		if(InputMappings.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT)){
			if(slot == EquipmentSlotType.HEAD)
				p_77624_3_.add(new StringTextComponent("Wear for Night Vision " + level));
			if(slot == EquipmentSlotType.CHEST)
				p_77624_3_.add(new StringTextComponent("Wear for Resistance " + level));
			if(slot == EquipmentSlotType.LEGS)
				p_77624_3_.add(new StringTextComponent("Wear for Speed " + level));
			if(slot == EquipmentSlotType.FEET)
				p_77624_3_.add(new StringTextComponent("Wear for Jump Boost " + level));
			
		}
		else
		 	p_77624_3_.add(new TranslationTextComponent("p_77624_3_.magicarmor.hold_shift"));
			
	}
	//When armor is worn, below effects are given
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		int level;
		if(enhanced == false)
			level = 0;
		else
			level = 1;
		if(slot == EquipmentSlotType.HEAD)
			player.addEffect(new EffectInstance(Effects.NIGHT_VISION, 300, level));
		if(slot == EquipmentSlotType.CHEST)
			player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 20, level));
		if(slot == EquipmentSlotType.LEGS)
			player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 20, level));
		if(slot == EquipmentSlotType.FEET)
			player.addEffect(new EffectInstance(Effects.JUMP, 20, level));
	}
	
	

}
