package com.betafoprhoton.endlesschanges;

import net.minecraftforge.common.ForgeConfigSpec
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = EndlessChangesMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
object EndlessChangesConfig {
    private val BUILDER = ForgeConfigSpec.Builder()

    val PlantMaxTickChance: ForgeConfigSpec.IntValue = BUILDER
        .comment("Chance of plant ticking per world tick. 0 - 100")
        .defineInRange("PlantMaxTickChance",10, 0, 100)
}
