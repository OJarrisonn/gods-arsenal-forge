package com.ojarrisonn.godsarsenal.armors;

import com.ojarrisonn.godsarsenal.GodsArsenal;
import com.ojarrisonn.godsarsenal.items.ModItemTabs;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class WindSpiritArmorItem extends ArmorItem {
    private static boolean falling = false;

    public WindSpiritArmorItem(EquipmentSlot slot) {
        super(ModArmorMaterials.WIND_SPIRIT, slot, new Item.Properties().tab(ModItemTabs.GODS_ARSENAL_TAB));
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(!world.isClientSide()) {
            if(hasFullSuitOfArmorOn(player)) {
                addStatusEffect(player);
            }
        }
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    private void addStatusEffect(Player player) {
        if(hasCorrectArmorOn(player)) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 4, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, 3, false, false));

            falling = player.fallDistance >= 3.5f && !player.isOnGround();

            if (falling && !player.hasEffect(MobEffects.SLOW_FALLING)) {
                player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 0, false, false));
            }
            else player.removeEffect(MobEffects.SLOW_FALLING);
        }
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty() && !breastplate.is(Items.ELYTRA) && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(Player player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == ModArmorMaterials.WIND_SPIRIT && breastplate.getMaterial() == ModArmorMaterials.WIND_SPIRIT &&
                leggings.getMaterial() == ModArmorMaterials.WIND_SPIRIT && boots.getMaterial() == ModArmorMaterials.WIND_SPIRIT;
    }
}