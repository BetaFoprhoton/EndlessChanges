package com.betafoprhoton.endlesschanges.util

import com.betafoprhoton.endlesschanges.util.PlantEnvironment.getCHumidityAt
import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level
import net.minecraft.world.level.material.Fluids
import net.minecraft.world.level.saveddata.SavedData
import net.minecraft.world.phys.AABB
import net.minecraftforge.common.ForgeConfig.Client

object PlantEnvironment {
    fun Level.getCHumidityAt(pos: BlockPos): Int {
        var waterLevel =
            if (this.isRainingAt(pos)) 100 else 0

        this.getBlockStates(
            AABB(
                BlockPos(pos.x - 3, pos.y - 2, pos.z - 3),
                BlockPos(pos.x + 3, pos.y + 2, pos.z + 3)
            )
        ).forEach { blockState ->
            waterLevel += if (blockState.fluidState.type == Fluids.WATER) 10 else 0
        }
        this.getBiome(pos).value().shouldFreeze(this, pos).let { waterLevel = if (it) 10 else waterLevel }
        this.getBiome(pos).value().shouldSnow(this, pos).let { waterLevel = if (it) 20 else waterLevel }
        this.getBiome(pos).value().modifiedClimateSettings.downfall.let { waterLevel =
            ((it * 0.25) * waterLevel).toInt() // is downfall humidity? not sure
        }
        return waterLevel
    }

    fun Level.getPlantRequiredElementRichnessAt(pos: BlockPos): PlantRequiredElement {

        this.getBlockStates(
            AABB(
                BlockPos(pos.x - 3, pos.y - 2, pos.z - 3),
                BlockPos(pos.x + 3, pos.y + 2, pos.z + 3)
            )
        ).forEach { blockState ->
            waterLevel += if (blockState.tags.anyMatch { it }) 10 else 0
        }
    }

}