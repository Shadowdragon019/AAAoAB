
package net.mcreator.aaaoab.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.aaaoab.world.dimension.CandymensionDimension;
import net.mcreator.aaaoab.AaaoabModElements;

import java.util.Random;

@AaaoabModElements.ModElement.Tag
public class HardRockCandyOreBlock extends AaaoabModElements.ModElement {
	@ObjectHolder("aaaoab:hard_rock_candy_ore")
	public static final Block block = null;
	public HardRockCandyOreBlock(AaaoabModElements instance) {
		super(instance, 30);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(6f, 6f).lightValue(0).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("hard_rock_candy_ore");
		}
	}
	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("aaaoab:toblerone_mountains")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new OreFeature(OreFeatureConfig::deserialize) {
				@Override
				public boolean place(IWorld world, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {
					DimensionType dimensionType = world.getDimension().getType();
					boolean dimensionCriteria = false;
					if (dimensionType == CandymensionDimension.type)
						dimensionCriteria = true;
					if (!dimensionCriteria)
						return false;
					return super.place(world, generator, rand, pos, config);
				}
			}.withConfiguration(
					new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("hard_rock_candy_ore", "hard_rock_candy_ore", blockAt -> {
						boolean blockCriteria = false;
						if (blockAt.getBlock() == CandyStoneBlock.block.getDefaultState().getBlock())
							blockCriteria = true;
						return blockCriteria;
					}), block.getDefaultState(), 12)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 16))));
		}
	}
}
