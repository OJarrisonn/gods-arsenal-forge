package com.ojarrisonn.godsarsenal.items;

import com.ojarrisonn.godsarsenal.armors.*;
import com.ojarrisonn.godsarsenal.blocks.ModBlocks;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import static com.ojarrisonn.godsarsenal.GodsArsenal.MOD_ID;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    /**********************
    * BLOCK ITEMS SECTION *
    ***********************/

    public static final RegistryObject<Item> HELLS_FORGE = ITEMS.register(
            "hells_forge",
            () -> new BlockItem(
                    ModBlocks.HELLS_FORGE.get(),
                    new Item.Properties().tab(ModItemTabs.GODS_ARSENAL_TAB)
            )
    );

    public static final RegistryObject<Item> SOULS_FORGE = ITEMS.register(
            "souls_forge",
            () -> new BlockItem(
                    ModBlocks.SOULS_FORGE.get(),
                    new Item.Properties().tab(ModItemTabs.GODS_ARSENAL_TAB)
            )
    );

    /******************
     * ARMORS SECTION *
     ******************/

    public static final RegistryObject<Item> UNDEAD_HELMET = ITEMS.register(
            "undead_helmet",
            () -> new UndeadArmorItem(EquipmentSlot.HEAD)
    );
    public static final RegistryObject<Item> UNDEAD_CHESTPLATE = ITEMS.register(
            "undead_chestplate",
            () -> new UndeadArmorItem(EquipmentSlot.CHEST)
    );
    public static final RegistryObject<Item> UNDEAD_LEGGINGS = ITEMS.register(
            "undead_leggings",
            () -> new UndeadArmorItem(EquipmentSlot.LEGS)
    );
    public static final RegistryObject<Item> UNDEAD_BOOTS = ITEMS.register(
            "undead_boots",
            () -> new UndeadArmorItem(EquipmentSlot.FEET)
    );

    public static final RegistryObject<Item> WIND_SPIRIT_HELMET = ITEMS.register(
            "wind_spirit_helmet",
            () -> new WindSpiritArmorItem(EquipmentSlot.HEAD)
    );
    public static final RegistryObject<Item> WIND_SPIRIT_CHESTPLATE = ITEMS.register(
            "wind_spirit_chestplate",
            () -> new WindSpiritArmorItem(EquipmentSlot.CHEST)
    );
    public static final RegistryObject<Item> WIND_SPIRIT_LEGGINGS = ITEMS.register(
            "wind_spirit_leggings",
            () -> new WindSpiritArmorItem(EquipmentSlot.LEGS)
    );
    public static final RegistryObject<Item> WIND_SPIRIT_BOOTS = ITEMS.register(
            "wind_spirit_boots",
            () -> new WindSpiritArmorItem(EquipmentSlot.FEET)
    );

    public static final RegistryObject<Item> ANCIENT_WOOD_HELMET = ITEMS.register(
            "ancient_wood_helmet",
            () -> new ModArmorItem(
                    ModArmorMaterials.ANCIENT_WOOD,
                    EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModItemTabs.GODS_ARSENAL_TAB),
                    true
            )
    );
    public static final RegistryObject<Item> ANCIENT_WOOD_CHESTPLATE = ITEMS.register(
            "ancient_wood_chestplate",
            () -> new ModArmorItem(
                    ModArmorMaterials.ANCIENT_WOOD,
                    EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModItemTabs.GODS_ARSENAL_TAB),
                    true
            )
    );
    public static final RegistryObject<Item> ANCIENT_WOOD_LEGGINGS = ITEMS.register(
            "ancient_wood_leggings",
            () -> new ModArmorItem(
                    ModArmorMaterials.ANCIENT_WOOD,
                    EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModItemTabs.GODS_ARSENAL_TAB),
                    true
            )
    );
    public static final RegistryObject<Item> ANCIENT_WOOD_BOOTS = ITEMS.register(
            "ancient_wood_boots",
            () -> new ModArmorItem(
                    ModArmorMaterials.ANCIENT_WOOD,
                    EquipmentSlot.FEET,
                    new Item.Properties().tab(ModItemTabs.GODS_ARSENAL_TAB),
                    true
            )
    );

    public static final RegistryObject<Item> GUARDIAN_HELMET = ITEMS.register(
            "guardian_helmet",
            () -> new GuardianArmorItem(EquipmentSlot.HEAD)
    );
    public static final RegistryObject<Item> GUARDIAN_CHESTPLATE = ITEMS.register(
            "guardian_chestplate",
            () -> new GuardianArmorItem(EquipmentSlot.CHEST)
    );
    public static final RegistryObject<Item> GUARDIAN_LEGGINGS = ITEMS.register(
            "guardian_leggings",
            () -> new GuardianArmorItem(EquipmentSlot.LEGS)
    );
    public static final RegistryObject<Item> GUARDIAN_BOOTS = ITEMS.register(
            "guardian_boots",
            () -> new GuardianArmorItem(EquipmentSlot.FEET)
    );
    
    public static final RegistryObject<Item> AUREA_HELMET = ITEMS.register(
            "aurea_helmet",
            () -> new AureaArmorItem(EquipmentSlot.HEAD)
    );
    public static final RegistryObject<Item> AUREA_CHESTPLATE = ITEMS.register(
            "aurea_chestplate",
            () -> new AureaArmorItem(EquipmentSlot.CHEST)
    );
    public static final RegistryObject<Item> AUREA_LEGGINGS = ITEMS.register(
            "aurea_leggings",
            () -> new AureaArmorItem(EquipmentSlot.LEGS)
    );
    public static final RegistryObject<Item> AUREA_BOOTS = ITEMS.register(
            "aurea_boots",
            () -> new AureaArmorItem(EquipmentSlot.FEET)
    );

    /******************
    * WEAPONS SECTION *
    *******************/

    public static final RegistryObject<Item> UNDEAD_BLADE = ITEMS.register(
            "undead_blade",
            UndeadBlade::new
    );

    /*********************
     * ARTIFACTS SECTION *
     *********************/

    public static final RegistryObject<Item> MJOLNIR = ITEMS.register(
            "mjolnir",
            Mjolnir::new
    );


    public static void register (IEventBus bus) {
        ITEMS.register(bus);
    }
}
