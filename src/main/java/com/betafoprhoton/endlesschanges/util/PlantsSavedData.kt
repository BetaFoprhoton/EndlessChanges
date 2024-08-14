package com.betafoprhoton.endlesschanges.util

import com.betafoprhoton.endlesschanges.plants.multiblock.GrassLikePlant
import com.betafoprhoton.endlesschanges.plants.multiblock.TreeLikePlant
import com.betafoprhoton.endlesschanges.plants.multiblock.VineLikePlant
import net.minecraft.nbt.CompoundTag
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.level.saveddata.SavedData

class PlantsSavedData(private val level: ServerLevel): SavedData() {
    protected val treeLikePlants = HashSet<TreeLikePlant>()
    protected val grassLikePlants = HashSet<GrassLikePlant>()
    protected val vineLikePlant = HashSet<VineLikePlant>()

    companion object {
        fun load(level: ServerLevel, tag: CompoundTag): PlantsSavedData {
            val data = PlantsSavedData(level)
            tag.getString("Grass").split(",")
            data.grassLikePlants.addAll()
            val plants = HashSet<TreeLikePlant>()

            return PlantsSavedData()
        }
    }

    override fun save(tag: CompoundTag): CompoundTag {
        tag.putString("Trees", treeLikePlants.toString())
        return tag
    }


}