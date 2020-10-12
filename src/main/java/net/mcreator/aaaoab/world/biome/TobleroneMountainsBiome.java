
package net.mcreator.aaaoab.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.BiomeManager;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;

import net.mcreator.aaaoab.block.CoatedChocolateBlockBlock;
import net.mcreator.aaaoab.block.ChocolateBlockBlock;
import net.mcreator.aaaoab.AaaoabModElements;

@AaaoabModElements.ModElement.Tag
public class TobleroneMountainsBiome extends AaaoabModElements.ModElement {
	@ObjectHolder("aaaoab:toblerone_mountains")
	public static final CustomBiome biome = null;
	public TobleroneMountainsBiome(AaaoabModElements instance) {
		super(instance, 27);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 10));
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(1f).scale(0.8f).temperature(0.5f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(CoatedChocolateBlockBlock.block.getDefaultState(),
							ChocolateBlockBlock.block.getDefaultState(), ChocolateBlockBlock.block.getDefaultState())));
			setRegistryName("toblerone_mountains");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
		}
	}
}
