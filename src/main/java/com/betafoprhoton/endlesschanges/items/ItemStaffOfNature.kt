package com.betafoprhoton.endlesschanges.items

import com.mojang.serialization.Codec
import net.minecraft.world.InteractionResult
import net.minecraft.world.item.Item
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.DataPackConfig
import net.minecraftforge.registries.DataPackRegistryEvent

class ItemStaffOfNature(properties: Properties) : Item(properties) {
    override fun useOn(context: UseOnContext): InteractionResult {
        if (context.level.isClientSide) return InteractionResult.SUCCESS

        return InteractionResult.PASS
    }
}