package com.betafoprhoton.endlesschanges.util

object ObjectPlantProperties {
    open class BodyBlock {
        val isEnabled = true

        var canStoreElement: IntArray = intArrayOf(0, 0, 0, 0, 0, 0) //C O N P K S
            set(value) {
                var temp = IntArray(6)
                if (value.size != 6)
                    for (i in value.indices)
                        temp[i] = value[i]
                field = temp
            }

        var canStoreWater = 0

        var heathStore = 0

        var keepCostWater = 0

        var growCostElement = PlantRequiredElement()

        var growCostWater = 0
            set(value) {field = value.coerceIn(0, 1000)}
    }

    class FoliageBlock: BodyBlock() {
        var genElement: IntArray = intArrayOf(0, 0, 0, 0, 0, 0) //C O N P K S
            set(value) {
                var temp = IntArray(6)
                if (value.size != 6)
                    for (i in value.indices)
                        temp[i] = value[i]
                field = temp
            }

        var genElementEfficiency: IntArray = intArrayOf(0, 0, 0, 0, 0, 0) //C O N P K S
            set(value) {
                var temp = IntArray(6)
                if (value.size != 6)
                    for (i in value.indices)
                        temp[i] = value[i]
                else temp = value
                field = temp.map { it.coerceIn(0, 1000) }.toIntArray()
            }

    }

    class RootBlock: BodyBlock() {
        var collectElementEfficiency: IntArray = intArrayOf(0, 0, 0, 0, 0, 0) //C O N P K S
            set(value) {
                var temp = IntArray(6)
                if (value.size != 6)
                    for (i in value.indices)
                        temp[i] = value[i]
                else temp = value
                field = temp.map { it.coerceIn(0, 1000) }.toIntArray()
            }

        var collectWaterEfficiency = 0
            set(value) {field = value.coerceIn(0, 1000)}

    }

    class PlantProperties {
        val name: String = ""
        var bodyBlock = BodyBlock()
        var foliageBlock = FoliageBlock()
        var rootBlock = RootBlock()
    }


}