package com.ojarrisonn.godsarsenal.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import static com.ojarrisonn.godsarsenal.GodsArsenal.MOD_ID;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static final RegistryObject<Block> HELLS_FORGE = BLOCKS.register(
            "hells_forge",
            () -> new Block(
                    BlockBehaviour.Properties
                            .of(Material.METAL, MaterialColor.COLOR_BLACK)
                            .strength(7f)
                            .requiresCorrectToolForDrops()
            )
    );

    public static final RegistryObject<Block> SOULS_FORGE = BLOCKS.register(
            "souls_forge",
            () -> new Block(
                    BlockBehaviour.Properties
                            .of(Material.STONE, MaterialColor.TERRACOTTA_BLUE)
                            .strength(5f)
                            .requiresCorrectToolForDrops()
            )
    );

    public static void register (IEventBus bus) {
        BLOCKS.register(bus);
    }
}
