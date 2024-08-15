package com.betafoprhoton.endlesschanges.util

import com.betafoprhoton.endlesschanges.plants.multiblock.GrassLikePlant
import com.betafoprhoton.endlesschanges.plants.multiblock.TreeLikePlant
import com.betafoprhoton.endlesschanges.plants.multiblock.VineLikePlant
import com.betafoprhoton.endlesschanges.util.extensions.getCompoundTags
import com.betafoprhoton.endlesschanges.util.extensions.putCompoundTags
import net.minecraft.nbt.CompoundTag
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.level.saveddata.SavedData

class PlantsSavedData(protected val level: ServerLevel) : SavedData() {
    protected val treeLikePlants = HashSet<TreeLikePlant>()
    protected val grassLikePlants = HashSet<GrassLikePlant>()
    protected val vineLikePlant = HashSet<VineLikePlant>()

    //Need for more efficient storage methods
    companion object {
        fun load(level: ServerLevel, tag: CompoundTag): PlantsSavedData {
            val data = PlantsSavedData(level)
            val lengths = tag.getIntArray("PlantsLength")

            tag.getCompoundTags("treeLikePlants", lengths[0])
                .map { TreeLikePlant.load(it) }
                .forEach { data.treeLikePlants.add(it) }
            tag.getCompoundTags("grassLikePlants", lengths[1])
                .map { GrassLikePlant.load(it) }
                .forEach { data.grassLikePlants.add(it) }
            tag.getCompoundTags("vineLikePlants", lengths[2])
                .map { VineLikePlant.load(it) }
                .forEach { data.vineLikePlant.add(it) }

            return data
        }
    }

    override fun save(tag: CompoundTag): CompoundTag {
        tag.putCompoundTags("treeLikePlants", treeLikePlants.map { it.save() })
        tag.putCompoundTags("grassLikePlants", grassLikePlants.map { it.save() })
        tag.putCompoundTags("vineLikePlants", vineLikePlant.map { it.save() })
        tag.putIntArray("PlantsLength", intArrayOf(treeLikePlants.size, grassLikePlants.size, vineLikePlant.size))
        return tag
    }
}