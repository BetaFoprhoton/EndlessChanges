package com.betafoprhoton.endlesschanges;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(EndlessChangesMain.MODID)
public class EndlessChangesMain {
    public static final String MODID = "endlesschanges";
    private static final Logger LOGGER = LogUtils.getLogger();

    public EndlessChangesMain() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);

        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, EndlessChangesConfig.SPEC);
    }

}
