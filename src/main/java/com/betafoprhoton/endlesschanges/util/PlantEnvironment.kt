package com.betafoprhoton.endlesschanges.util

import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.Fluids

object PlantEnvironment {
    fun Level.getCHumidityAt(pos: BlockPos): Int {
        var waterLevel =
            if (this.isRainingAt(pos)) 100 else 0

        this.blockStatesWithPos(
            BlockPos(pos.x - 3, pos.y - 2, pos.z - 3),
            BlockPos(pos.x + 3, pos.y + 2, pos.z + 3)
        ) { npos, state ->
            waterLevel += if (state.fluidState.type == Fluids.WATER)
                    (10 * (10 - pos.distToCenterSqr(npos.center))).toInt()
            else 0
        }


        this.getBiome(pos).value().shouldFreeze(this, pos).let { waterLevel = if (it) 10 else waterLevel }
        this.getBiome(pos).value().shouldSnow(this, pos).let { waterLevel = if (it) 20 else waterLevel }
        this.getBiome(pos).value().modifiedClimateSettings.downfall.let { waterLevel =
            ((it * 0.25) * waterLevel).toInt() // is downfall humidity? not sure
        }
        return waterLevel
    }

    fun Level.getPlantRequiredElementRichnessAt(pos: BlockPos): PlantRequiredElement {
        val richness = PlantRequiredElement()
        this.blockStatesWithPos(
                BlockPos(pos.x - 3, pos.y - 2, pos.z - 3),
                BlockPos(pos.x + 3, pos.y + 2, pos.z + 3)
        ) { pos, state ->

        }

        return richness
    }

    fun Level.blockStatesWithPos(pos1: BlockPos, pos2: BlockPos, action: (pos: BlockPos, state: BlockState) -> Unit) {
        for (x in pos1.x..pos2.x) { // x
            for (y in pos1.y..pos2.y) { // y
                for (z in pos1.z..pos2.z) { // z
                    val pos = BlockPos(x, y, z)
                    val state = this.getBlockState(pos)
                    action(pos, state)
                }
            }
        }
    }

}