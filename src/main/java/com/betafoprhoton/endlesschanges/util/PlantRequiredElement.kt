package com.betafoprhoton.endlesschanges.util

import net.minecraft.nbt.CompoundTag

class PlantRequiredElement(n: Int, p: Int, k: Int, s: Int) {
    protected var nitrogen: Int = 0
        set(value) {field = value.coerceIn(0, 100)}
    protected var phosphors: Int = 0
        set(value) {field = value.coerceIn(0, 100)}
    protected var potassium: Int = 0
        set(value) {field = value.coerceIn(0, 100)}
    protected var sulfur: Int = 0
        set(value) {field = value.coerceIn(0, 100)}

    init {
        nitrogen = n
        phosphors = p
        potassium = k
        sulfur = s
    }

    constructor() : this(0, 0, 0, 0)

    companion object {
        fun load(tag: CompoundTag): PlantRequiredElement  {
            val element = tag.getIntArray("element")
            return PlantRequiredElement(element[0], element[1], element[2], element[3])
        }
    }

    fun save(): CompoundTag {
        val tag = CompoundTag()
        tag.putIntArray("element", intArrayOf(nitrogen, phosphors, potassium, sulfur))
        return tag
    }


}