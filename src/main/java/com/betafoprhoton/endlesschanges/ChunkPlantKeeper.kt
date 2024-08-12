package com.betafoprhoton.endlesschanges

import com.betafoprhoton.endlesschanges.plants.AbstractPlant
import net.minecraft.world.level.chunk.ChunkAccess
import net.minecraftforge.event.level.ChunkEvent

class ChunkPlantKeeper(private val chunk: ChunkAccess) {
    private val plants: MutableSet<AbstractPlant> = mutableSetOf()
    fun addPlant(plant: AbstractPlant) {
        plants.add(plant)
    }
}