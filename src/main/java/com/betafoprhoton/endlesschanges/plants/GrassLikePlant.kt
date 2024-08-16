package com.betafoprhoton.endlesschanges.plants

import com.betafoprhoton.endlesschanges.util.extensions.isAllLoaded
import com.betafoprhoton.endlesschanges.util.extensions.toBlockPos
import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.server.level.ServerLevel

class GrassLikePlant : AbstractPlant() {
    protected val main = HashSet<BlockPos>()
    protected val roots = HashSet<BlockPos>()

    override fun tick(level: ServerLevel) {
        super.tick(level)
        if (!level.isAllLoaded(main, roots)) return

    }

    companion object {
        fun load(tag: CompoundTag): GrassLikePlant {
            val plant = AbstractPlant.load(tag) as GrassLikePlant
            plant.main.addAll(tag.getLongArray("main").map { it.toBlockPos() })
            plant.roots.addAll(tag.getLongArray("rootsBlocks").map { it.toBlockPos() })
            return plant
        }
    }

    override fun save(): CompoundTag {
        val tag = super.save()
        tag.putLongArray("main", main.map { it.asLong() }.toLongArray())
        tag.putLongArray("rootsBlocks", roots.map { it.asLong() }.toLongArray())
        return tag
    }


}
