
package net.mcreator.aaaoab.world.structure;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.block.BlockState;

import net.mcreator.aaaoab.world.dimension.CandymensionDimension;
import net.mcreator.aaaoab.procedures.ChocolateTreeSmall1OnStructureInstanceGeneratedProcedure;
import net.mcreator.aaaoab.procedures.ChocolateTreeSmall1AdditionalGenerationConditionProcedure;
import net.mcreator.aaaoab.block.CoatedChocolateBlockBlock;
import net.mcreator.aaaoab.AaaoabModElements;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import com.google.common.collect.ImmutableMap;

@AaaoabModElements.ModElement.Tag
public class ChocolateTreeSmall1Structure extends AaaoabModElements.ModElement {
	public ChocolateTreeSmall1Structure(AaaoabModElements instance) {
		super(instance, 48);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		Feature<NoFeatureConfig> feature = new Feature<NoFeatureConfig>(NoFeatureConfig::deserialize) {
			@Override
			public boolean place(IWorld world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
				int ci = (pos.getX() >> 4) << 4;
				int ck = (pos.getZ() >> 4) << 4;
				DimensionType dimensionType = world.getDimension().getType();
				boolean dimensionCriteria = false;
				if (dimensionType == CandymensionDimension.type)
					dimensionCriteria = true;
				if (!dimensionCriteria)
					return false;
				if ((random.nextInt(1000000) + 1) <= 1000000) {
					int count = random.nextInt(5) + 1;
					for (int a = 0; a < count; a++) {
						int i = ci + random.nextInt(16);
						int k = ck + random.nextInt(16);
						int j = world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, i, k);
						j -= 1;
						BlockState blockAt = world.getBlockState(new BlockPos(i, j, k));
						boolean blockCriteria = false;
						if (blockAt.getBlock() == CoatedChocolateBlockBlock.block.getDefaultState().getBlock())
							blockCriteria = true;
						if (!blockCriteria)
							continue;
						Rotation rotation = Rotation.values()[random.nextInt(3)];
						Mirror mirror = Mirror.values()[random.nextInt(2)];
						BlockPos spawnTo = new BlockPos(i, j + 0, k);
						int x = spawnTo.getX();
						int y = spawnTo.getY();
						int z = spawnTo.getZ();
						if (!ChocolateTreeSmall1AdditionalGenerationConditionProcedure.executeProcedure(ImmutableMap.of("y", y)))
							continue;
						Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("aaaoab", "air"));
						if (template == null)
							return false;
						template.addBlocksToWorld(world, spawnTo, new PlacementSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
								.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).setChunk(null).setIgnoreEntities(false));
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("x", x);
							$_dependencies.put("y", y);
							$_dependencies.put("z", z);
							$_dependencies.put("world", world);
							ChocolateTreeSmall1OnStructureInstanceGeneratedProcedure.executeProcedure($_dependencies);
						}
					}
				}
				return true;
			}
		};
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("aaaoab:toblerone_mountains")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, feature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
					.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		}
	}
}
