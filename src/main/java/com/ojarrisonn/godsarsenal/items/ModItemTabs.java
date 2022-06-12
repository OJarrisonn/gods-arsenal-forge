package com.ojarrisonn.godsarsenal.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemTabs {
    public static final CreativeModeTab GODS_ARSENAL_TAB = new CreativeModeTab("gods_arsenal_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.UNDEAD_CHESTPLATE.get());
        }
    };
}
