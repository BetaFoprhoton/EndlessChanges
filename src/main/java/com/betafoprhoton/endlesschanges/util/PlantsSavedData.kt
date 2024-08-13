package com.betafoprhoton.endlesschanges.util

import com.betafoprhoton.endlesschanges.plants.multiblock.TreeLikePlant
import net.minecraft.nbt.CompoundTag
import net.minecraft.world.level.levelgen.feature.TreeFeature
import net.minecraft.world.level.saveddata.SavedData

class PlantsSavedData: SavedData() {
    private val plants = HashSet<TreeLikePlant>()
    override fun save(p0: CompoundTag): CompoundTag {

    }
}