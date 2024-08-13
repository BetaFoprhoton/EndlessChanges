package com.betafoprhoton.endlesschanges.util

data class PlantRequiredElement (
    var N: Int = 0,
    var P: Int = 0,
    var K: Int = 0,
    var S: Int = 0,
    ) {
    constructor() : this(0, 0, 0, 0)
}