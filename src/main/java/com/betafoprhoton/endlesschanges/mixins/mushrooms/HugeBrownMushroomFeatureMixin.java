package com.betafoprhoton.endlesschanges.mixins.mushrooms;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.HugeBrownMushroomFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HugeBrownMushroomFeature.class)
public class HugeBrownMushroomFeatureMixin {
    @Inject(method = "makeCap", at = @At("RETURN"), cancellable = true)
    protected void makeCap(LevelAccessor p_225043_, RandomSource p_225044_, BlockPos p_225045_, int p_225046_, BlockPos.MutableBlockPos p_225047_, HugeMushroomFeatureConfiguration p_225048_, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(3);
    }
}
