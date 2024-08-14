package com.betafoprhoton.endlesschanges.event

import com.betafoprhoton.endlesschanges.EndlessChangesMain
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.event.level.ChunkEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber

@EventBusSubscriber(modid = EndlessChangesMain.MODID, bus = EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
object ChunkListener {
    @SubscribeEvent
    fun onChunkLoad(event: ChunkEvent.Load?) {
        event ?: return

    }
}