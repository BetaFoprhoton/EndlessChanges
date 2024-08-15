package com.betafoprhoton.endlesschanges.plants.multiblock

import com.betafoprhoton.endlesschanges.plants.AbstractPlant
import com.betafoprhoton.endlesschanges.util.PlantRequiredElement
import com.betafoprhoton.endlesschanges.util.extensions.toBlockPos
import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag

class VineLikePlant(): AbstractPlant() {
    protected val vines = HashSet<BlockPos>()
    protected val attaches = HashSet<BlockPos>()

    companion object {
        fun load(tag: CompoundTag): VineLikePlant {
            val plant = AbstractPlant.load(tag) as VineLikePlant
            plant.vines.addAll(tag.getLongArray("vines").map { it.toBlockPos() })
            plant.attaches.addAll(tag.getLongArray("attaches").map { it.toBlockPos() })
            return plant
        }
    }

    override fun save(): CompoundTag {
        val tag = super.save()
        tag.putLongArray("vines", vines.map { it.asLong() }.toLongArray())
        tag.putLongArray("attaches", attaches.map { it.asLong() }.toLongArray())
        return tag
    }
}