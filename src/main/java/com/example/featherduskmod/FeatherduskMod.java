package com.example.featherduskmod;

import net.minecraft.item.ItemGroup; 
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.featherduskmod.core.init.BlockInit;
import com.example.featherduskmod.core.init.ItemInit;
import com.example.featherduskmod.core.init.PotionInit;
import com.example.featherduskmod.world.OreGeneration;

//=================================================================================
//	FeatherduskMod.java 		Author: Vibha Raghu	
//
//	Main class
//=================================================================================


// The value here should match an entry in the META-INF/mods.toml file
@Mod("featherduskmod")
public class FeatherduskMod
{
	
	//Unique Mod ID
	public static final String MOD_ID = "featherduskmod";
	
	//Custom creative tab name
	public static final ItemGroup MAGIC_GROUP = new MagicGroup("magictab");
	 
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public FeatherduskMod() {
    	
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus(); //allows for mods to intercept Vanilla code
    	bus.addListener(this::setup);
    	
    	//registering different initializations to the event bus
    	ItemInit.ITEMS.register(bus); //register the ItemInit class to event bus
    	BlockInit.BLOCKS.register(bus);//register the BlockInit class to event bus
        PotionInit.EFFECTS.register(bus);//register the PotionInit class EFFECTS to event bus
        PotionInit.POTIONS.register(bus);//register the PotionInit class POTIONS to event bus
        

        
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
    	PotionInit.addPotionRecipe(); 
       
    }
    
    //=================================================================================
    //	Creates a custom creative tab with all the new modded items.
    //=================================================================================
    
    public static class MagicGroup extends ItemGroup{

		//Sets the name of the label
    	public MagicGroup(String label) {
			super(label);
			
		}
    	

		@Override
		public ItemStack makeIcon() {
			
			return ItemInit.RED_JEWEL.get().getDefaultInstance(); //makes the icon of the tab the RED_JEWEL item
		}
		
		//Fills the creative tab manually with all the new modded items
		@Override
		public void fillItemList(NonNullList<ItemStack> p_78018_1_) {
			
			//Since potions cannot be called as an ItemStack object, a new ItemStack object must be created
			//in order to add them to the creative tab
			ItemStack yellowJewelPotion = PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.YELLOW_JEWEL_POTION.get());
			ItemStack longYellowJewelPotion = PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.LONG_YELLOW_JEWEL_POTION.get());
			ItemStack strongYellowJewelPotion = PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.STRONG_YELLOW_JEWEL_POTION.get());
			
			ItemStack splashYellowJewelPotion = PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), PotionInit.YELLOW_JEWEL_POTION.get());
			ItemStack splashLongYellowJewelPotion = PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), PotionInit.LONG_YELLOW_JEWEL_POTION.get());
			ItemStack splashStrongYellowJewelPotion = PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), PotionInit.STRONG_YELLOW_JEWEL_POTION.get());
			
			ItemStack lingeringYellowJewelPotion = PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), PotionInit.YELLOW_JEWEL_POTION.get());
			ItemStack lingeringLongYellowJewelPotion = PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), PotionInit.LONG_YELLOW_JEWEL_POTION.get());
			ItemStack lingeringStrongYellowJewelPotion = PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), PotionInit.STRONG_YELLOW_JEWEL_POTION.get());
			
			ItemStack tippedArrowYellowJewelPotion = PotionUtils.setPotion(new ItemStack(Items.TIPPED_ARROW), PotionInit.YELLOW_JEWEL_POTION.get());
			ItemStack tippedArrowLongYellowJewelPotion = PotionUtils.setPotion(new ItemStack(Items.TIPPED_ARROW), PotionInit.LONG_YELLOW_JEWEL_POTION.get());
			ItemStack tippedArrowStrongYellowJewelPotion = PotionUtils.setPotion(new ItemStack(Items.TIPPED_ARROW), PotionInit.STRONG_YELLOW_JEWEL_POTION.get());
			
			
			//adding every modded item to the creative tab in the following specific order
			p_78018_1_.add(ItemInit.JEWELED_ORE.get().getDefaultInstance());
			
			p_78018_1_.add(ItemInit.RED_JEWEL.get().getDefaultInstance());
			p_78018_1_.add(ItemInit.RED_JEWEL_INGOT.get().getDefaultInstance());
			p_78018_1_.add(ItemInit.WAND.get().getDefaultInstance());
			
			p_78018_1_.add(ItemInit.BLUE_JEWEL.get().getDefaultInstance());
			p_78018_1_.add(ItemInit.BLUE_POWDER.get().getDefaultInstance());
			p_78018_1_.add(ItemInit.BLUE_POWDERED_APPLE.get().getDefaultInstance());
			p_78018_1_.add(ItemInit.BLUE_POWDERED_COOKIE.get().getDefaultInstance());
			p_78018_1_.add(ItemInit.BLUE_POWDERED_PIE.get().getDefaultInstance());
			p_78018_1_.add(ItemInit.BLUE_POWDERED_DRIED_KELP.get().getDefaultInstance());
			
			
			p_78018_1_.add(ItemInit.YELLOW_JEWEL.get().getDefaultInstance());
			p_78018_1_.add(yellowJewelPotion);
			p_78018_1_.add(longYellowJewelPotion);
			p_78018_1_.add(strongYellowJewelPotion);
			
			p_78018_1_.add(splashYellowJewelPotion);
			p_78018_1_.add(splashLongYellowJewelPotion);
			p_78018_1_.add(splashStrongYellowJewelPotion);
			
			p_78018_1_.add(lingeringYellowJewelPotion);
			p_78018_1_.add(lingeringLongYellowJewelPotion);
			p_78018_1_.add(lingeringStrongYellowJewelPotion);
			
			p_78018_1_.add(tippedArrowYellowJewelPotion);
			p_78018_1_.add(tippedArrowLongYellowJewelPotion);
			p_78018_1_.add(tippedArrowStrongYellowJewelPotion);
			
			p_78018_1_.add(ItemInit.GREEN_JEWEL.get().getDefaultInstance());
			p_78018_1_.add(ItemInit.GREEN_JEWEL_BOOTS.get().getDefaultInstance());
			p_78018_1_.add(ItemInit.GREEN_JEWEL_CHESTPLATE.get().getDefaultInstance());
			p_78018_1_.add(ItemInit.GREEN_JEWEL_HELMET.get().getDefaultInstance());
			p_78018_1_.add(ItemInit.GREEN_JEWEL_LEGGINGS.get().getDefaultInstance());
			p_78018_1_.add(ItemInit.ENHANCED_GREEN_JEWEL_BOOTS.get().getDefaultInstance());
			p_78018_1_.add(ItemInit.ENHANCED_GREEN_JEWEL_CHESTPLATE.get().getDefaultInstance());
			p_78018_1_.add(ItemInit.ENHANCED_GREEN_JEWEL_HELMET.get().getDefaultInstance());
			p_78018_1_.add(ItemInit.ENHANCED_GREEN_JEWEL_LEGGINGS.get().getDefaultInstance());
			
		}
    }
}

//----------------------------------------------------------------
//	Credits
//
//	https://minecraft.novaskin.me/resourcepacks#default/assets/minecraft/textures/items
//	https://misode.github.io/loot-table/
//	https://crafting.thedestruc7i0n.ca/
//	https://files.minecraftforge.net/net/minecraftforge/forge/
//	https://www.youtube.com/channel/UCicAXLV4w2X6bn2EuM4To4w
// 	https://www.youtube.com/watch?v=uQEfNkY5fJc
//	https://hlgr360.github.io/blog/blog/minecraft-forge-install/
//	https://minecraft.fandom.com/wiki/Tutorials/Creating_Forge_mods
//	https://forums.minecraftforge.net/
//
//-----------------------------------------------------------------

	