package com.betafoprhoton.endlesschanges.plants

import com.betafoprhoton.endlesschanges.util.ObjectPlantProperties
import com.betafoprhoton.endlesschanges.util.PlantRequiredElement
import net.minecraft.nbt.CompoundTag
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.level.block.VineBlock

open class AbstractPlant {
    private val plantProperties = ObjectPlantProperties.PlantProperties()
    protected var water: Int = 0
        set(value) { field = if (maxWater != -1) value.coerceIn(0, maxWater) else value }
    protected var health: Int = 0
        set(value) { field = if (maxHeath != -1) value.coerceIn(0, maxHeath) else value }
    protected var element = PlantRequiredElement()
    protected var lastTick: Long = 0
    var maxWater = 100000
    var maxHeath = 100000

    open fun tick(level: ServerLevel) {
        //TODO needn't super.tick()
    }

    companion object {
        fun load(tag: CompoundTag): AbstractPlant {
            val plant = AbstractPlant()
            plant.health = tag.getInt("health")
            plant.water = tag.getInt("water")
            plant.maxWater = tag.getInt("maxWater")
            plant.maxHeath = tag.getInt("maxHeath")
            plant.element = PlantRequiredElement.load(tag.getCompound("element"))
            plant.lastTick = tag.getLong("lastTick")
            return plant
        }
    }

    open fun save(): CompoundTag {
        val tag = CompoundTag()
        tag.putInt("water", water)
        tag.putInt("health", health)
        tag.putInt("maxWater", maxWater)
        tag.putInt("maxHeath", maxHeath)
        tag.put("element", element.save())
        tag.putLong("lastTick", lastTick)
        return tag
    }

}