package com.example.featherduskmod.common.items;



import java.util.List;   
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

//=================================================================================
// Wand.java		Author: Vibha Raghu
//
// Child class of SwordItem. Creates a special Wand item that has complex properties 
// and overridden methods 
//=================================================================================

public class Wand extends SwordItem{

	
	public Wand(IItemTier p_i48460_1_, int p_i48460_2_, float p_i48460_3_, Properties p_i48460_4_) {
		super(p_i48460_1_, p_i48460_2_, p_i48460_3_, p_i48460_4_);
		//Wand Material, damage, speed, Item Properties/tab
	}

	
	//--------------------------------------------------------------------
	// Provides a "tool tip" to the Wand. When mouse hovers over the item
	// in the inventory the option for additional information appears. 
	//--------------------------------------------------------------------
	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack p_77624_1_, World p_77624_2_, List<ITextComponent> p_77624_3_,
			ITooltipFlag p_77624_4_) {
		
		super.appendHoverText(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
		if(InputMappings.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT)){
			
			p_77624_3_.add(new StringTextComponent("Right Click to Summon Fire\nLeft Click for Weakness"));
			
		}
		else
		 	p_77624_3_.add(new TranslationTextComponent("p_77624_3_.wand.hold_shift"));		
	}
	
	//--------------------------------------------------------------------
	// Summons a fire ball in the direction the player is looking 
	// when the item is used (right clicked). 
	//--------------------------------------------------------------------
	@Override
	public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
			
		
		if(!p_77659_2_.getCooldowns().isOnCooldown(this)) //checks for cool down
		{
			ItemStack item = p_77659_2_.getItemInHand(p_77659_3_); // Item in player's hand
			Vector3d aim = p_77659_2_.getLookAngle(); //3D vector the player is looking at
			FireballEntity fireball = new FireballEntity(p_77659_1_, p_77659_2_, 1, 1, 1); //Creates a fireball entity at an initial position
		
			//Sets position at player head
			fireball.setPos(p_77659_2_.getX() + aim.x * (1.5D),p_77659_2_.getY() 
					+ aim.y * 1.5D + 2.0 , p_77659_2_.getZ() + aim.z * 1.5D);
			
			//Sets acceleration of fireball in direction player is looking
			fireball.xPower = aim.x * 0.3; 
			fireball.yPower = aim.y * 0.3;
			fireball.zPower = aim.z * 0.3;
			
			//adds the fireball to the world
			p_77659_1_.addFreshEntity(fireball);
			
			
			item.hurtAndBreak(4, p_77659_2_, null); //damages item by 4 uses after use of method
			
			p_77659_2_.getCooldowns().addCooldown(this, 100); //cool down is 100 ticks or 10 seconds
			
			return ActionResult.success(p_77659_2_.getItemInHand(p_77659_3_)); //action is success
		
		}
		
		return ActionResult.fail(p_77659_2_.getItemInHand(p_77659_3_)); //action has failed
		 
	}
	
	//--------------------------------------------------------------------
	//	Adds the effect of Weakness for 200 ticks (20 seconds) 
	//  and ampflier of 3
	//--------------------------------------------------------------------
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
		
		((LivingEntity)entity).addEffect(new EffectInstance(Effects.WEAKNESS, 200, 3)); 
			
		return false;
	}
	
}
