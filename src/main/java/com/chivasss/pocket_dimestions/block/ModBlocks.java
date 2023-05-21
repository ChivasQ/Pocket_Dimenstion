package com.chivasss.pocket_dimestions.block;

import com.chivasss.pocket_dimestions.PocketDim;
import com.chivasss.pocket_dimestions.block.custom.ZincLamp;
import com.chivasss.pocket_dimestions.block.custom.asphalt;
import com.chivasss.pocket_dimestions.item.ModCreativeModTab;
import com.chivasss.pocket_dimestions.item.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PocketDim.MODID);


    public static final RegistryObject<Block> ZINC_BLOCK = registerBlock("zinc_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6f)
            .requiresCorrectToolForDrops()
    ), ModCreativeModTab.MOD_TAB);

    public static final RegistryObject<Block> ZINC_ORE = registerBlock("zinc_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(4f)
            .requiresCorrectToolForDrops()
    ), ModCreativeModTab.MOD_TAB);

    public static final RegistryObject<Block> DEEPSLATE_ZINC_ORE = registerBlock("deepslate_zinc_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(7f)
            .requiresCorrectToolForDrops()
    ), ModCreativeModTab.MOD_TAB);


    public static final RegistryObject<Block> ZINC_LAMP = registerBlock("zinc_lamp", () -> new ZincLamp(BlockBehaviour.Properties.of(Material.STONE)
            .strength(3f)
            .requiresCorrectToolForDrops()
            .lightLevel(state -> state.getValue(ZincLamp.LIT) ? 0 : 15)
    ), ModCreativeModTab.MOD_TAB);

    public static final RegistryObject<Block> ASPHALT = registerBlock("asphalt", () -> new asphalt(BlockBehaviour.Properties.of(Material.STONE)
            .strength(4f)
    ), ModCreativeModTab.MOD_TAB);






    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
