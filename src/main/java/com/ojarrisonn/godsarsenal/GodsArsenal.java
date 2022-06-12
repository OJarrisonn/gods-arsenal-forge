package com.ojarrisonn.godsarsenal;

import com.ojarrisonn.godsarsenal.blocks.ModBlocks;
import com.ojarrisonn.godsarsenal.items.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.logging.Logger;

import static com.ojarrisonn.godsarsenal.GodsArsenal.MOD_ID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MOD_ID)
public class GodsArsenal {
    public static final String MOD_ID = "godsarsenal";
    public static final Logger LOGGER = Logger.getLogger(MOD_ID);

    public GodsArsenal() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();


        ModBlocks.register(bus);
        ModItems.register(bus);


        bus.addListener(this::clientSetup);
        bus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
}