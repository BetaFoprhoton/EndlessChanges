package com.betafoprhoton.endlesschanges.plants

import com.betafoprhoton.endlesschanges.util.extensions.toBlockPos
import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.server.level.ServerLevel

class TreeLikePlant(): AbstractPlant() {
    protected val trunks = HashSet<BlockPos>()
    protected val foliage = HashSet<BlockPos>()
    protected val roots = HashSet<BlockPos>()

    override fun tick(level: ServerLevel) {
        super.tick(level)
        TODO()
    }

    companion object {
        fun load(tag: CompoundTag): TreeLikePlant {
            val plant = AbstractPlant.load(tag) as TreeLikePlant
            plant.trunks.addAll(tag.getLongArray("trunks").map { it.toBlockPos() })
            plant.foliage.addAll(tag.getLongArray("foliage").map { it.toBlockPos() })
            plant.roots.addAll(tag.getLongArray("roots").map { it.toBlockPos() })
            return plant
        }
    }

    override fun save(): CompoundTag {
        val tag = super.save()
        tag.putLongArray("trunks", trunks.map { it.asLong() }.toLongArray())
        tag.putLongArray("foliage", foliage.map { it.asLong() }.toLongArray())
        tag.putLongArray("roots", roots.map { it.asLong() }.toLongArray())
        return tag
    }
}