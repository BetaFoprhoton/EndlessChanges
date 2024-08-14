package com.betafoprhoton.endlesschanges.plants

import net.minecraft.server.level.ServerLevel

abstract class AbstractPlant(private val level: ServerLevel) {
    protected var water: Int = 0
        set(value) {field = value.coerceIn(0, 100)}
    protected var health: Int = 0
        set(value) {field = value.coerceIn(0, 100)}

    protected val minGrowWater: Int = 10
    protected val mixGrowHealth: Int = 10

    abstract fun valueOf(string: String)

}