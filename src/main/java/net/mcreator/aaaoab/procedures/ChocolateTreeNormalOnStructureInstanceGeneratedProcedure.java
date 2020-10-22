package net.mcreator.aaaoab.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.block.Blocks;

import net.mcreator.aaaoab.block.ChcolateLogBlock;
import net.mcreator.aaaoab.AaaoabModElements;

import java.util.Map;

@AaaoabModElements.ModElement.Tag
public class ChocolateTreeNormalOnStructureInstanceGeneratedProcedure extends AaaoabModElements.ModElement {
	public ChocolateTreeNormalOnStructureInstanceGeneratedProcedure(AaaoabModElements instance) {
		super(instance, 55);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure ChocolateTreeNormalOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure ChocolateTreeNormalOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure ChocolateTreeNormalOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ChocolateTreeNormalOnStructureInstanceGenerated!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double TreeHeight = 0;
		double CurrentHeight = 0;
		TreeHeight = (double) (((new java.util.Random()).nextInt((int) 2 + 1)) + 1);
		CurrentHeight = (double) 0;
		for (int index0 = 0; index0 < (int) ((TreeHeight)); index0++) {
			world.setBlockState(new BlockPos((int) x, (int) (y + (CurrentHeight)), (int) z), ChcolateLogBlock.block.getDefaultState(), 3);
			CurrentHeight = (double) ((CurrentHeight) + 1);
		}
		if (!world.getWorld().isRemote) {
			Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
					.getTemplateDefaulted(new ResourceLocation("aaaoab", "chocolate_tree_normal_head"));
			if (template != null) {
				template.addBlocksToWorld(world, new BlockPos((int) (x + (-2)), (int) (y + (CurrentHeight)), (int) (z + (-2))),
						new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
			}
		}
		for (int index1 = 0; index1 < (int) ((((new java.util.Random()).nextInt((int) 1 + 1)) + 1)); index1++) {
			world.setBlockState(
					new BlockPos((int) (x + (-2)), (int) ((y + (CurrentHeight)) + ((new java.util.Random()).nextInt((int) 1 + 1))), (int) (z + (-2))),
					Blocks.AIR.getDefaultState(), 3);
		}
		for (int index2 = 0; index2 < (int) ((((new java.util.Random()).nextInt((int) 1 + 1)) + 1)); index2++) {
			world.setBlockState(
					new BlockPos((int) (x + 2), (int) ((y + (CurrentHeight)) + ((new java.util.Random()).nextInt((int) 1 + 1))), (int) (z + (-2))),
					Blocks.AIR.getDefaultState(), 3);
		}
		for (int index3 = 0; index3 < (int) ((((new java.util.Random()).nextInt((int) 1 + 1)) + 1)); index3++) {
			world.setBlockState(
					new BlockPos((int) (x + (-2)), (int) ((y + (CurrentHeight)) + ((new java.util.Random()).nextInt((int) 1 + 1))), (int) (z + 2)),
					Blocks.AIR.getDefaultState(), 3);
		}
		for (int index4 = 0; index4 < (int) ((((new java.util.Random()).nextInt((int) 1 + 1)) + 1)); index4++) {
			world.setBlockState(
					new BlockPos((int) (x + 2), (int) ((y + (CurrentHeight)) + ((new java.util.Random()).nextInt((int) 1 + 1))), (int) (z + 2)),
					Blocks.AIR.getDefaultState(), 3);
		}
		world.setBlockState(new BlockPos((int) (x + (-1)), (int) (((y + (CurrentHeight)) + ((new java.util.Random()).nextInt((int) 1 + 1))) + 1),
				(int) (z + (-1))), Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(
				new BlockPos((int) (x + 1), (int) (((y + (CurrentHeight)) + ((new java.util.Random()).nextInt((int) 1 + 1))) + 1), (int) (z + (-1))),
				Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(
				new BlockPos((int) (x + (-1)), (int) (((y + (CurrentHeight)) + ((new java.util.Random()).nextInt((int) 1 + 1))) + 1), (int) (z + 1)),
				Blocks.AIR.getDefaultState(), 3);
		world.setBlockState(
				new BlockPos((int) (x + 1), (int) (((y + (CurrentHeight)) + ((new java.util.Random()).nextInt((int) 1 + 1))) + 1), (int) (z + 1)),
				Blocks.AIR.getDefaultState(), 3);
	}
}
