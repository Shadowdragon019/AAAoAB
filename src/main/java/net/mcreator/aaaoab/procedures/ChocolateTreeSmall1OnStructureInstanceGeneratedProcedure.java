package net.mcreator.aaaoab.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.aaaoab.block.ChocolateLeavesBlock;
import net.mcreator.aaaoab.block.ChcolateLogBlock;
import net.mcreator.aaaoab.AaaoabModElements;

import java.util.Map;

@AaaoabModElements.ModElement.Tag
public class ChocolateTreeSmall1OnStructureInstanceGeneratedProcedure extends AaaoabModElements.ModElement {
	public ChocolateTreeSmall1OnStructureInstanceGeneratedProcedure(AaaoabModElements instance) {
		super(instance, 49);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure ChocolateTreeSmall1OnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure ChocolateTreeSmall1OnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure ChocolateTreeSmall1OnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ChocolateTreeSmall1OnStructureInstanceGenerated!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double LogsNum = 0;
		double StoredNum = 0;
		LogsNum = (double) 1;
		StoredNum = (double) 0;
		for (int index0 = 0; index0 < (int) (4); index0++) {
			StoredNum = (double) ((StoredNum) + 1);
			world.setBlockState(new BlockPos((int) x, (int) (y + (StoredNum)), (int) z), ChcolateLogBlock.block.getDefaultState(), 3);
		}
		for (int index1 = 0; index1 < (int) ((((new java.util.Random()).nextInt((int) 1 + 1)) + 1)); index1++) {
			LogsNum = (double) ((LogsNum) + 1);
			StoredNum = (double) 1;
			for (int index2 = 0; index2 < (int) (2); index2++) {
				world.setBlockState(new BlockPos((int) (x + (StoredNum)), (int) (y + (LogsNum)), (int) z),
						ChocolateLeavesBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) (y + (LogsNum)), (int) (z + (StoredNum))),
						ChocolateLeavesBlock.block.getDefaultState(), 3);
				StoredNum = (double) (-1);
			}
			if ((((new java.util.Random()).nextInt((int) 1 + 1)) == 0)) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) (y + (LogsNum)), (int) (z + 1)), ChocolateLeavesBlock.block.getDefaultState(),
						3);
				world.setBlockState(new BlockPos((int) (x - 1), (int) (y + (LogsNum)), (int) (z + 1)), ChocolateLeavesBlock.block.getDefaultState(),
						3);
				world.setBlockState(new BlockPos((int) (x + 1), (int) (y + (LogsNum)), (int) (z - 1)), ChocolateLeavesBlock.block.getDefaultState(),
						3);
				world.setBlockState(new BlockPos((int) (x - 1), (int) (y + (LogsNum)), (int) (z - 1)), ChocolateLeavesBlock.block.getDefaultState(),
						3);
			}
		}
		world.setBlockState(new BlockPos((int) x, (int) ((y + (LogsNum)) + 1), (int) z), ChocolateLeavesBlock.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) x, (int) ((y + (LogsNum)) + 2), (int) z), ChocolateLeavesBlock.block.getDefaultState(), 3);
		StoredNum = (double) 1;
		for (int index3 = 0; index3 < (int) (2); index3++) {
			world.setBlockState(new BlockPos((int) (x + (StoredNum)), (int) ((y + (LogsNum)) + 1), (int) z),
					ChocolateLeavesBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) ((y + (LogsNum)) + 1), (int) (z + (StoredNum))),
					ChocolateLeavesBlock.block.getDefaultState(), 3);
			StoredNum = (double) (-1);
		}
	}
}
