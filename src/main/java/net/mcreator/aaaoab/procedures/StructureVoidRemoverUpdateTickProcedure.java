package net.mcreator.aaaoab.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.aaaoab.block.StructureVoidRemoverBlock;
import net.mcreator.aaaoab.AaaoabModElements;

import java.util.Map;

@AaaoabModElements.ModElement.Tag
public class StructureVoidRemoverUpdateTickProcedure extends AaaoabModElements.ModElement {
	public StructureVoidRemoverUpdateTickProcedure(AaaoabModElements instance) {
		super(instance, 9);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure StructureVoidRemoverUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure StructureVoidRemoverUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure StructureVoidRemoverUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure StructureVoidRemoverUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double offset = 0;
		offset = (double) 1;
		for (int index0 = 0; index0 < (int) (2); index0++) {
			if ((Blocks.STRUCTURE_VOID.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) (x + (offset)), (int) y, (int) z)))
					.getBlock())) {
				world.setBlockState(new BlockPos((int) (x + (offset)), (int) y, (int) z), StructureVoidRemoverBlock.block.getDefaultState(), 3);
			}
			if ((Blocks.STRUCTURE_VOID.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y + (offset)), (int) z)))
					.getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + (offset)), (int) z), StructureVoidRemoverBlock.block.getDefaultState(), 3);
			}
			if ((Blocks.STRUCTURE_VOID.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + (offset)))))
					.getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + (offset))), StructureVoidRemoverBlock.block.getDefaultState(), 3);
			}
			offset = (double) (-1);
		}
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
	}
}
