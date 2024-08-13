package com.betafoprhoton.endlesschanges.plants.multiblock

import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level

class TreeLikePlant(
    private val level: Level,
    private val trunks: HashSet<BlockPos>,
    private val foliage: HashSet<BlockPos>,
    private val roots: HashSet<BlockPos>,) {
    constructor(level: Level): this(level, HashSet(), HashSet(), HashSet())

    fun addTrunks(trunks: List<BlockPos>) {
        this.trunks.addAll(trunks)
    }

    fun addFoliage(leaves: List<BlockPos>) {
        this.foliage.addAll(leaves)
    }

    fun addRoots(roots: List<BlockPos>) {
        this.roots.addAll(roots)
    }
}