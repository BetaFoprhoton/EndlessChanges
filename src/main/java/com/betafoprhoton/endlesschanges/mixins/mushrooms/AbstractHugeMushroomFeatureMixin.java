package com.betafoprhoton.endlesschanges.mixins.mushrooms;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.AbstractHugeMushroomFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(AbstractHugeMushroomFeature.class)
public abstract class AbstractHugeMushroomFeatureMixin {

    /**
     * @author BetaFoprhoton
     * @reason to get the whole mushroom for more features
     */
    @Overwrite
    public boolean place(FeaturePlaceContext<HugeMushroomFeatureConfiguration> p_159436_) {
        WorldGenLevel $$1 = p_159436_.level();
        BlockPos $$2 = p_159436_.origin();
        RandomSource $$3 = p_159436_.random();
        HugeMushroomFeatureConfiguration $$4 = (HugeMushroomFeatureConfiguration)p_159436_.config();
        int $$5 = this.getTreeHeight($$3);
        BlockPos.MutableBlockPos $$6 = new BlockPos.MutableBlockPos();
        if (!this.isValidPosition($$1, $$2, $$5, $$6, $$4)) {
            return false;
        } else {
            this.makeCap($$1, $$3, $$2, $$5, $$6, $$4);
            this.placeTrunk($$1, $$3, $$2, $$4, $$5, $$6);
            return true;
        }
    }


    @Shadow
    protected abstract boolean isValidPosition(LevelAccessor p_65099_, BlockPos p_65100_, int p_65101_, BlockPos.MutableBlockPos p_65102_, HugeMushroomFeatureConfiguration p_65103_);


    @Shadow
    protected abstract int getTreeHeight(RandomSource $$3);
}
