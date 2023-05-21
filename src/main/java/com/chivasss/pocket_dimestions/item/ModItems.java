package com.chivasss.pocket_dimestions.item;

import com.chivasss.pocket_dimestions.PocketDim;
import com.chivasss.pocket_dimestions.block.ModBlocks;
import com.chivasss.pocket_dimestions.item.custom.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.SnowballItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PocketDim.MODID);

    public static final RegistryObject<Item> ZINC = ITEMS.register("zinc",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.MOD_TAB)));

    public static final RegistryObject<Item> EIGTH_BALL = ITEMS.register("eight_ball",
            () -> new EigthBallItem(new Item.Properties()
                    .tab(ModCreativeModTab.MOD_TAB)
                    .stacksTo(1)));

    public static final RegistryObject<Item> COORD_FINDER = ITEMS.register("coord_finder",
            () -> new CoordFinder(new Item.Properties()
                    .tab(ModCreativeModTab.MOD_TAB)
                    .stacksTo(1)));

    public static final RegistryObject<Item> RANDOM_EFF = ITEMS.register("random_eff",
            () -> new RandomEffects(new Item.Properties()
                    .tab(ModCreativeModTab.MOD_TAB)
                    .stacksTo(1)));

    public static final RegistryObject<Item> RAW_ZINC = ITEMS.register("raw_zinc",
            () -> new RandomEffects(new Item.Properties()
                    .tab(ModCreativeModTab.MOD_TAB)
                    .stacksTo(128)));

    public static final RegistryObject<Item> STICK_OF_DYNAMITE = ITEMS.register("stick_of_dynamite",
            () -> new StickofDynamite(new Item.Properties()
                    .tab(ModCreativeModTab.MOD_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
