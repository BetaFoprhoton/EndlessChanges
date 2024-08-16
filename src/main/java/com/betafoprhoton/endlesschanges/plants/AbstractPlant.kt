package com.betafoprhoton.endlesschanges.plants

import com.betafoprhoton.endlesschanges.util.PlantRequiredElement
import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.server.level.ServerLevel

open class AbstractPlant() {
    protected var water: Int = 0
        set(value) {field = value.coerceIn(0, 100)}
    protected var health: Int = 0
        set(value) {field = value.coerceIn(0, 100)}
    protected var element = PlantRequiredElement()
    protected var lastTick: Long = 0

    open fun tick(level: ServerLevel) {
        // TODO: Implement
        if ()

    }


    companion object {
        fun load(tag: CompoundTag): AbstractPlant {
            val plant = AbstractPlant()
            plant.health = tag.getInt("health")
            plant.water = tag.getInt("water")
            plant.element = PlantRequiredElement.load(tag.getCompound("element"))
            plant.lastTick = tag.getLong("lastTick")
            return plant
        }
    }

    open fun save(): CompoundTag {
        val tag = CompoundTag()
        tag.putInt("water", water)
        tag.putInt("health", health)
        tag.put("element", element.save())
        tag.putLong("lastTick", lastTick)
        return tag
    }

}