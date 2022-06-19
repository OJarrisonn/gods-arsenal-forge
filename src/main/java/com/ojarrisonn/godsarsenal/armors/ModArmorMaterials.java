package com.ojarrisonn.godsarsenal.armors;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

import static com.ojarrisonn.godsarsenal.GodsArsenal.MOD_ID;

public enum ModArmorMaterials implements ArmorMaterial {
    UNDEAD("undead", 100, new int[]{7, 9, 12, 7}, 0, SoundEvents.ARMOR_EQUIP_LEATHER, 4.0F, 0.1F, () -> {
        return Ingredient.of(Items.NETHER_STAR);
    }),
    WIND_SPIRIT("wind_spirit", 50, new int[]{1,3,4,1}, 0, SoundEvents.ARMOR_EQUIP_IRON, 0F, 0F, () -> {
        return Ingredient.of(Items.NETHER_STAR);
    }),
    GUARDIAN("guardian", 50, new int[]{2,3,4,2}, 0, SoundEvents.ARMOR_EQUIP_LEATHER, 0F, 0F, () -> {
        return Ingredient.of(Items.NETHER_STAR);
    }),
    ANCIENT_WOOD("ancient_wood", 500, new int[]{10, 12, 16, 10}, 0, SoundEvents.WOOD_PLACE, 5.0f, 1f, () -> {
        return Ingredient.of(Items.NETHER_STAR);
    }),
    AUREA("aurea", 1000, new int[]{1, 2, 3, 1}, 0, SoundEvents.AMETHYST_BLOCK_PLACE, 1.0f, 2f, () -> {
        return Ingredient.of(Items.NETHER_STAR);
    });

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private ModArmorMaterials(String p_name, int p_durMod, int[] p_sltProt, int p_enchVal, SoundEvent p_sound, float p_toughness, float p_knockRes, Supplier<Ingredient> p_repIng) {
        this.name = p_name;
        this.durabilityMultiplier = p_durMod;
        this.slotProtections = p_sltProt;
        this.enchantmentValue = p_enchVal;
        this.sound = p_sound;
        this.toughness = p_toughness;
        this.knockbackResistance = p_knockRes;
        this.repairIngredient = new LazyLoadedValue<>(p_repIng);
    }

    public int getDurabilityForSlot(EquipmentSlot p_40484_) {
        return HEALTH_PER_SLOT[p_40484_.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot p_40487_) {
        return this.slotProtections[p_40487_.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
