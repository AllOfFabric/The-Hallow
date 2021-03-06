package io.github.alloffabric.thehallow.world;

import io.github.alloffabric.thehallow.registry.HallowedFeatures;
import net.minecraft.block.sapling.LargeTreeSaplingGenerator;
import net.minecraft.world.gen.feature.BranchedTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.MegaTreeFeatureConfig;

import java.util.Random;

public class DeadwoodSaplingGenerator extends LargeTreeSaplingGenerator {
	@Override
	protected ConfiguredFeature<BranchedTreeFeatureConfig, ?> createTreeFeature(Random rand, boolean bool) {
		return HallowedFeatures.SMALL_DEADWOOD_TREE.configure(HallowedFeatures.SMALL_DEADWOOD_TREE_CONFIG);
	}

	@Override
	protected ConfiguredFeature<MegaTreeFeatureConfig, ?> createLargeTreeFeature(Random var1) {
		return HallowedFeatures.LARGE_DEADWOOD_TREE.configure(HallowedFeatures.LARGE_DEADWOOD_TREE_CONFIG);
	}
}
