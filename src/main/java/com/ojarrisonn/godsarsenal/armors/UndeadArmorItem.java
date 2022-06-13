package com.ojarrisonn.godsarsenal.armors;

import com.ojarrisonn.godsarsenal.items.ModItemTabs;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class UndeadArmorItem extends ArmorItem {
    public UndeadArmorItem(EquipmentSlot slot) {
        super(ModArmorMaterials.UNDEAD, slot, new Properties().tab(ModItemTabs.GODS_ARSENAL_TAB));
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(!world.isClientSide()) {
            if(hasFullSuitOfArmorOn(player)) {
                addStatusEffect(player);
                player.setArrowCount(0);
            }
        }
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    private void addStatusEffect(Player player) {
        if(hasCorrectArmorOn(player)) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 4, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 9, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, 1, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 0, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 100, 0, false, false));

            if (!player.hasEffect(MobEffects.ABSORPTION)) {
                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 160, 4, false, false));
            }
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

        return helmet.getMaterial() == ModArmorMaterials.UNDEAD && breastplate.getMaterial() == ModArmorMaterials.UNDEAD &&
                leggings.getMaterial() == ModArmorMaterials.UNDEAD && boots.getMaterial() == ModArmorMaterials.UNDEAD;
    }
}