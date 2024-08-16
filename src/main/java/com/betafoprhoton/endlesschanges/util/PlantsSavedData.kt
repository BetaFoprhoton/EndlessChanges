package com.betafoprhoton.endlesschanges.util

import com.betafoprhoton.endlesschanges.plants.GrassLikePlant
import com.betafoprhoton.endlesschanges.plants.TreeLikePlant
import com.betafoprhoton.endlesschanges.plants.VineLikePlant
import com.betafoprhoton.endlesschanges.util.extensions.getCompoundTags
import com.betafoprhoton.endlesschanges.util.extensions.putCompoundTags
import net.minecraft.nbt.CompoundTag
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.level.saveddata.SavedData

class PlantsSavedData(protected val level: ServerLevel) : SavedData() {
    protected val treeLikePlants = HashSet<TreeLikePlant>()
    protected val grassLikePlants = HashSet<GrassLikePlant>()
    protected val vineLikePlant = HashSet<VineLikePlant>()
    var serverTickTime: Long = 0

    fun tick() {
        treeLikePlants.forEach { it.tick(level) }
        grassLikePlants.forEach { it.tick(level) }
        vineLikePlant.forEach { it.tick(level) }
        serverTickTime ++
    }

    //Need for more efficient storage methods
    companion object {
        fun load(level: ServerLevel, tag: CompoundTag): PlantsSavedData {
            val data = PlantsSavedData(level)

            tag.getCompoundTags("treeLikePlants")
                .map { TreeLikePlant.load(it) }
                .forEach { data.treeLikePlants.add(it) }
            tag.getCompoundTags("grassLikePlants")
                .map { GrassLikePlant.load(it) }
                .forEach { data.grassLikePlants.add(it) }
            tag.getCompoundTags("vineLikePlants")
                .map { VineLikePlant.load(it) }
                .forEach { data.vineLikePlant.add(it) }
            data.serverTickTime = tag.getLong("serverTickTime")

            return data
        }
    }

    override fun save(tag: CompoundTag): CompoundTag {
        tag.putCompoundTags("treeLikePlants", treeLikePlants.map { it.save() })
        tag.putCompoundTags("grassLikePlants", grassLikePlants.map { it.save() })
        tag.putCompoundTags("vineLikePlants", vineLikePlant.map { it.save() })
        tag.putLong("serverTickTime", serverTickTime)
        return tag
    }
}