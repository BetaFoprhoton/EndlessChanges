package com.betafoprhoton.endlesschanges.util.extensions

import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraftforge.registries.ForgeRegistries.ITEMS
import java.util.stream.Collectors

internal fun String.isAnItemName(): Boolean {
    return ITEMS.containsKey(ResourceLocation(this));
}

internal fun String.getSetOfItemFromString(itemNames: List<String>): MutableSet<Item?> {
    val it =itemNames.stream()
        .map { ITEMS.getValue(ResourceLocation(this)) }
        .collect(Collectors.toSet())
    return it ?: return HashSet()
}

internal fun Long.toBlockPos(): BlockPos {
    return BlockPos.of(this)
}

internal fun CompoundTag.putCompoundTags(id: String, tags: Collection<CompoundTag>) {
    for ((i, tag) in tags.withIndex()) {
        this.put("$id-$i", tag)
    }
}

internal fun CompoundTag.getCompoundTags(id: String, length: Int): HashSet<CompoundTag> {
    val tags = HashSet<CompoundTag>()
    for (i in 0 .. length) {
        this.getCompound("$id-$i").let { tags.add(it) }
    }
    return tags
}


