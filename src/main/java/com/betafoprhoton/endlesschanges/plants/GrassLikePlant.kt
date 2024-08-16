package com.betafoprhoton.endlesschanges.plants

import com.betafoprhoton.endlesschanges.util.extensions.isAllLoaded
import com.betafoprhoton.endlesschanges.util.extensions.toBlockPos
import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.server.level.ServerLevel

class GrassLikePlant : AbstractPlant() {
    protected val mainBlocks = HashSet<BlockPos>()
    protected val rootsBlocks = HashSet<BlockPos>()

    override fun tick(level: ServerLevel) {
        super.tick(level)
        level.isAllLoaded(mainBlocks, rootsBlocks)

    }

    companion object {
        fun load(tag: CompoundTag): GrassLikePlant {
            val plant = AbstractPlant.load(tag) as GrassLikePlant
            plant.mainBlocks.addAll(tag.getLongArray("mainBlocks").map { it.toBlockPos() })
            plant.rootsBlocks.addAll(tag.getLongArray("rootsBlocks").map { it.toBlockPos() })
            return plant
        }
    }

    override fun save(): CompoundTag {
        val tag = super.save()
        tag.putLongArray("mainBlocks", mainBlocks.map { it.asLong() }.toLongArray())
        tag.putLongArray("rootsBlocks", rootsBlocks.map { it.asLong() }.toLongArray())
        return tag
    }


}
