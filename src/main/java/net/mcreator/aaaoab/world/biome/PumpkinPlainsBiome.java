
package net.mcreator.aaaoab.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.block.Blocks;

import net.mcreator.aaaoab.AaaoabModElements;

@AaaoabModElements.ModElement.Tag
public class PumpkinPlainsBiome extends AaaoabModElements.ModElement {
	@ObjectHolder("aaaoab:pumpkin_plains")
	public static final CustomBiome biome = null;
	public PumpkinPlainsBiome(AaaoabModElements instance) {
		super(instance, 25);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 5));
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(0f).scale(0f).temperature(0.5f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
							Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));
			setRegistryName("pumpkin_plains");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(8))));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getGrassColor(double posX, double posZ) {
			return -31232;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getFoliageColor() {
			return -31232;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColor() {
			return -29184;
		}
	}
}
