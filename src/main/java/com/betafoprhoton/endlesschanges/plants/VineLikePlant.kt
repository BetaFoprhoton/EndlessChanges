package com.betafoprhoton.endlesschanges.plants

import com.betafoprhoton.endlesschanges.util.extensions.isAllLoaded
import com.betafoprhoton.endlesschanges.util.extensions.toBlockPos
import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.server.level.ServerLevel

class VineLikePlant: AbstractPlant() {
    protected val vines = HashSet<BlockPos>()
    protected val attaches = HashSet<BlockPos>()

    override fun tick(level: ServerLevel) {
        if (!level.isAllLoaded(vines, attaches)) return
    }

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