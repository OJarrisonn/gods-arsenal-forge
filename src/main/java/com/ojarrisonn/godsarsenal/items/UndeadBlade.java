package com.ojarrisonn.godsarsenal.items;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;

public class UndeadBlade extends SwordItem {
    public UndeadBlade() {
        super(Tiers.NETHERITE, 10, -0.75f, new Item.Properties().setNoRepair().tab(ModItemTabs.GODS_ARSENAL_TAB).rarity(Rarity.EPIC).stacksTo(1));
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (!player.getLevel().isClientSide()) {
            // TODO: Absorb entity soul and let the player stronger
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
}
