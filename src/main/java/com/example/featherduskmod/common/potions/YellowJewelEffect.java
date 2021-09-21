package com.example.featherduskmod.common.potions;


import net.minecraft.entity.LivingEntity;  
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.world.World;

//=================================================================================
// 	YellowJewelEffect.java		Author: Vibha Raghu	
//
//	Creates the Yellow Jewel Effect
//=================================================================================


public class YellowJewelEffect extends Effect{
	
	public YellowJewelEffect(EffectType p_i50391_1_, int p_i50391_2_) {
		super(p_i50391_1_, p_i50391_2_);
		//Effect type: Beneficial, Neutral, or Harmful
		//Color code of Effect
		
	}
	
	@Override
	//Applied after every call for the effect
	public void applyEffectTick(LivingEntity p_76394_1_, int p_76394_2_) {
		
		World world = p_76394_1_.getCommandSenderWorld(); //world object
		
		if (p_76394_1_.isOnFire() == false && world.isRaining() == false) //if entity is on not on fire and the world is not raining
		{
		
			if(p_76394_2_ == 1) //if effect is level 1 then two fire balls will be summoned
			{
				FireballEntity fireball2 = new FireballEntity(world, p_76394_1_, 1, 1, 1); //Fire ball object
				world.addFreshEntity(fireball2); //spawns the FireBall entity
				fireball2.setPos(p_76394_1_.getX(), p_76394_1_.getY() + 1, p_76394_1_.getZ()); //sets potion of Firebal at entity location
				fireball2.xPower = 0; 
				fireball2.yPower = -.5; //sets acceleration of fire ball straight down. 
				fireball2.zPower = 0;
			}
			
		FireballEntity fireball = new FireballEntity(world, p_76394_1_, 1, 1, 1);
		world.addFreshEntity(fireball);
		fireball.setPos(p_76394_1_.getX(), p_76394_1_.getY() + 1, p_76394_1_.getZ());
		fireball.xPower = 0; 
		fireball.yPower = -.5;
		fireball.zPower = 0;
		}
		
		//sets entity on fire
		p_76394_1_.setRemainingFireTicks(130);
		p_76394_1_.setSecondsOnFire(130/20);
		
	}
	
	//Returns true during the duration of the effect when the ticks are a multiple of 60
	@Override
	public boolean isDurationEffectTick(int p_76397_1_, int p_76397_2_) {
		//Ticks are a unit of time in minecraft
		//There are 20 ticks in a second
		//returns true when ticks are a multiple of 60 ticks or 3 seconds. 
		//After every 3 seconds the applyEffectTick method is called
		return p_76397_1_ % 60 == 0;
		
	}

}
