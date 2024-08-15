package com.betafoprhoton.endlesschanges.plants

import com.betafoprhoton.endlesschanges.util.PlantRequiredElement
import net.minecraft.nbt.CompoundTag

open class AbstractPlant() {
    protected var water: Int = 0
        set(value) {field = value.coerceIn(0, 100)}
    protected var health: Int = 0
        set(value) {field = value.coerceIn(0, 100)}
    protected var element = PlantRequiredElement()

    companion object {
        fun load(tag: CompoundTag): AbstractPlant {
            val plant = AbstractPlant()
            plant.health = tag.getInt("health")
            plant.water = tag.getInt("water")
            plant.element = PlantRequiredElement.load(tag.getCompound("element"))
            return plant
        }
    }

    open fun save(): CompoundTag {
        val tag = CompoundTag()
        tag.putInt("water", water)
        tag.putInt("health", health)
        tag.put("element", element.save())
        return tag
    }

}