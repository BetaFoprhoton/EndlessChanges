package com.betafoprhoton.endlesschanges.util

import net.minecraft.nbt.CompoundTag

class PlantRequiredElement(c: Int, o: Int, n: Int, p: Int, k: Int, s: Int) {
    protected var carbon: Int = 0
        set(value) { field = if (maxCarbon != -1) value.coerceIn(0, maxCarbon) else value }
    protected var oxygen: Int = 0
        set(value) { field = if (maxOxygen != -1) value.coerceIn(0, maxOxygen) else value }
    protected var nitrogen: Int = 0
        set(value) { field = if (maxNitrogen != -1) value.coerceIn(0, maxNitrogen) else value }
    protected var phosphors: Int = 0
        set(value) { field = if (maxPhosphors != -1) value.coerceIn(0, maxPhosphors) else value }
    protected var potassium: Int = 0
        set(value) { field = if (maxPotassium != -1) value.coerceIn(0, maxPotassium) else value }
    protected var sulfur: Int = 0
        set(value) { field = if (maxSulfur != -1) value.coerceIn(0, maxSulfur) else value }
    private var maxCarbon = 100000
    private var maxOxygen = 100000
    private var maxNitrogen = 100000
    private var maxPhosphors = 100000
    private var maxPotassium = 100000
    private var maxSulfur = 100000

    fun setMaxElements(value: IntArray) {
        if (value.size != 6) return
        maxCarbon = value[0]
        maxOxygen = value[1]
        maxNitrogen = value[2]
        maxPhosphors = value[3]
        maxPotassium = value[4]
        maxSulfur = value[5]
    }

    fun getMaxElements() = intArrayOf(maxCarbon, maxOxygen, maxNitrogen, maxPhosphors, maxPotassium, maxSulfur)

    init {
        carbon = c
        oxygen = o
        nitrogen = n
        phosphors = p
        potassium = k
        sulfur = s
    }

    constructor() : this(0, 0, 0, 0, 0, 0)

    companion object {
        fun load(tag: CompoundTag): PlantRequiredElement  {
            val elementArray = tag.getIntArray("element")
            val element = PlantRequiredElement(elementArray[0], elementArray[1], elementArray[2], elementArray[3], elementArray[4], elementArray[5])
            element.setMaxElements(tag.getIntArray("elementMax"))
            return element
        }
    }

    fun save(): CompoundTag {
        val tag = CompoundTag()
        tag.putIntArray("elementMax", intArrayOf(maxCarbon, maxOxygen, maxNitrogen, maxPhosphors, maxPotassium, maxSulfur))
        tag.putIntArray("element", intArrayOf(carbon, oxygen, nitrogen, phosphors, potassium, sulfur))
        return tag
    }


}