package com.chivasss.pocket_dimestions.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab MOD_TAB = new CreativeModeTab("PocketDim") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ZINC.get());
        }
    };
}
