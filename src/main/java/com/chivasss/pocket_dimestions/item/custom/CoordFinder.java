package com.chivasss.pocket_dimestions.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CoordFinder extends Item {
    public CoordFinder(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){

            //random
            getCoords(player);
            //Cooldown
            player.getCooldowns().addCooldown(this, 1);

        }
        return super.use(level, player, hand);
    }

    private void getCoords(Player player){
        player.sendSystemMessage(player.getDisplayName());
        player.sendSystemMessage(Component.literal(""+
                "§cX: "+ Math.round(player.getX()) +"\n" +
                "§aY: "+ Math.round(player.getY()) + "\n" +
                "§9Z: "+ Math.round(player.getZ())));
    }

}
