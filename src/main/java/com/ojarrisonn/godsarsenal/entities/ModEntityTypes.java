package com.ojarrisonn.godsarsenal.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.ojarrisonn.godsarsenal.GodsArsenal.MOD_ID;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, MOD_ID);

    public static final RegistryObject<EntityType<MjolnirBolt>> MJOLNIR_BOLT = ENTITY_TYPES.register("mjolnir_bolt", () -> EntityType.Builder.<MjolnirBolt>of(MjolnirBolt::new, MobCategory.MISC).sized(0.2F, 0.2F).clientTrackingRange(4).updateInterval(10).build("mjolnir_bolt"));


}
