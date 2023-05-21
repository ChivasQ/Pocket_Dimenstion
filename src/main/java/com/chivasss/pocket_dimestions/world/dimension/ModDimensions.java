package com.chivasss.pocket_dimestions.world.dimension;

import com.chivasss.pocket_dimestions.PocketDim;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;


public class ModDimensions {
    public static final ResourceKey<Level> POCKET_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(PocketDim.MODID, "pocketdim"));

    public static final ResourceKey<DimensionType> POCKET_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,  new ResourceLocation(PocketDim.MODID, "pocketdim"));

    public static void register() {
        System.out.println("Registering" + PocketDim.MODID);
    }



}
