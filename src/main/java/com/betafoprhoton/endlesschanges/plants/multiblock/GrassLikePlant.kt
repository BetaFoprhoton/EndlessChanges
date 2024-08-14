package com.betafoprhoton.endlesschanges.plants.multiblock

import com.betafoprhoton.endlesschanges.plants.AbstractPlant
import net.minecraft.core.BlockPos
import net.minecraft.core.GlobalPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.level.WorldGenLevel
import net.minecraft.world.level.block.FlowerBlock
import net.minecraft.world.level.block.GrassBlock
import net.minecraft.world.level.block.grower.OakTreeGrower
import net.minecraft.world.level.levelgen.GenerationStep.Decoration
import net.minecraft.world.level.levelgen.WorldGenerationContext
import net.minecraftforge.event.level.ChunkDataEvent

class GrassLikePlant(level: ServerLevel): AbstractPlant(level) {
    private val mainBlock: BlockPos
    private val rootsBlocks = HashSet

    override fun valueOf(string: String) {

    }

}