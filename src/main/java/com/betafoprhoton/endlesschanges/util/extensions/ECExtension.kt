package com.betafoprhoton.endlesschanges.util.extensions

import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.nbt.ListTag
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.item.Item
import net.minecraftforge.registries.ForgeRegistries.ITEMS
import java.util.stream.Collectors

internal fun String.isAnItemName(): Boolean {
    return ITEMS.containsKey(ResourceLocation(this));
}

internal fun String.getSetOfItemFromString(itemNames: List<String>): MutableSet<Item?> {
    val it = itemNames.stream()
        .map { ITEMS.getValue(ResourceLocation(this)) }
        .collect(Collectors.toSet())
    return it ?: return HashSet()
}

internal fun Long.toBlockPos(): BlockPos {
    return BlockPos.of(this)
}

internal fun CompoundTag.putCompoundTags(id: String, tags: Collection<CompoundTag>) {
    val listTag = ListTag()
    listTag.addAll(tags)
    this.put(id, listTag)
}

internal fun CompoundTag.getCompoundTags(id: String): HashSet<CompoundTag> {
    val tags = HashSet<CompoundTag>()
    this.getList(id, 10).forEach { tags.add(it as CompoundTag) }
    return tags
}


internal fun ServerLevel.isAllLoaded(vararg sets: HashSet<BlockPos>): Boolean {
    sets.forEach {
        it.forEach { pos ->
            if (!this.isLoaded(pos))
                return false
        }
    }
    return true
}


