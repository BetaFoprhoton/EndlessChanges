package com.betafoprhoton.endlesschanges.util

class PlantRequiredElement(n: Int, p: Int, k: Int, s: Int) {
    var nitrogen: Int = 0
        set(value) {field = value.coerceIn(0, 100)}
    var phosphors: Int = 0
        set(value) {field = value.coerceIn(0, 100)}
    var potassium: Int = 0
        set(value) {field = value.coerceIn(0, 100)}
    var sulfur: Int = 0
        set(value) {field = value.coerceIn(0, 100)}

    init {
        nitrogen = n
        phosphors = p
        potassium = k
        sulfur = s
    }

    constructor() : this(0, 0, 0, 0)
}