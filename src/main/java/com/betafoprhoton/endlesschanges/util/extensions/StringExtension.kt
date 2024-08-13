package com.betafoprhoton.endlesschanges.util.extensions

import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraftforge.registries.ForgeRegistries
import java.util.stream.Collectors

fun String.isAnItemName(): Boolean {
    return ForgeRegistries.ITEMS.containsKey(ResourceLocation(this));
}

fun String.getSetOfItemFromString(itemNames: List<String>): MutableSet<Item?> {
    val it =itemNames.stream()
        .map { ForgeRegistries.ITEMS.getValue(ResourceLocation(this)) }
        .collect(Collectors.toSet())
    return it ?: return HashSet()
}