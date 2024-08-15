package com.betafoprhoton.endlesschanges.plants.multiblock

import com.betafoprhoton.endlesschanges.plants.AbstractPlant
import com.betafoprhoton.endlesschanges.util.extensions.toBlockPos
import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag

class GrassLikePlant : AbstractPlant() {
    var mainBlockPos: BlockPos = BlockPos.ZERO
    protected val rootsBlocks = HashSet<BlockPos>()

    companion object {
        fun load(tag: CompoundTag): GrassLikePlant {
            val plant = AbstractPlant.load(tag) as GrassLikePlant
            plant.mainBlockPos = tag.getLong("mainBlockPos").toBlockPos()
            plant.rootsBlocks.addAll(tag.getLongArray("rootsBlocks").map { it.toBlockPos() })
            return plant
        }
    }

    override fun save(): CompoundTag {
        val tag = super.save()
        tag.putLong("mainBlockPos", mainBlockPos.asLong())
        tag.putLongArray("rootsBlocks", rootsBlocks.map { it.asLong() }.toLongArray())
        return tag
    }


}
