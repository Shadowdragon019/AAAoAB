package net.mcreator.aaaoab.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.aaaoab.AaaoabModElements;

import java.util.Map;

@AaaoabModElements.ModElement.Tag
public class PumpkinPasturesHouseOnStructureInstanceGeneratedProcedure extends AaaoabModElements.ModElement {
	public PumpkinPasturesHouseOnStructureInstanceGeneratedProcedure(AaaoabModElements instance) {
		super(instance, 14);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PumpkinPasturesHouseOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PumpkinPasturesHouseOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PumpkinPasturesHouseOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PumpkinPasturesHouseOnStructureInstanceGenerated!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double offset = 0;
		offset = (double) 0;
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) (x - 9), (int) (y + 3), (int) (z - 1)),
				world.getBlockState(new BlockPos((int) (x - 9), (int) (y + 3), (int) (z - 1))).getBlock(), (int) 60);
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) (x - 9), (int) (y + 3), (int) (z - 5)),
				world.getBlockState(new BlockPos((int) (x - 9), (int) (y + 3), (int) (z - 5))).getBlock(), (int) 60);
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) (x - 9), (int) (y + 3), (int) (z - 9)),
				world.getBlockState(new BlockPos((int) (x - 9), (int) (y + 3), (int) (z - 9))).getBlock(), (int) 60);
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) (x + 9), (int) (y + 3), (int) (z + 1)),
				world.getBlockState(new BlockPos((int) (x + 9), (int) (y + 3), (int) (z + 1))).getBlock(), (int) 60);
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) (x + 9), (int) (y + 3), (int) (z + 5)),
				world.getBlockState(new BlockPos((int) (x + 9), (int) (y + 3), (int) (z + 5))).getBlock(), (int) 60);
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) (x + 9), (int) (y + 3), (int) (z + 9)),
				world.getBlockState(new BlockPos((int) (x + 9), (int) (y + 3), (int) (z + 9))).getBlock(), (int) 60);
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) (x - 1), (int) (y + 3), (int) (z + 9)),
				world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 3), (int) (z + 9))).getBlock(), (int) 60);
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) (x - 5), (int) (y + 3), (int) (z + 9)),
				world.getBlockState(new BlockPos((int) (x - 5), (int) (y + 3), (int) (z + 9))).getBlock(), (int) 60);
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) (x - 9), (int) (y + 3), (int) (z + 9)),
				world.getBlockState(new BlockPos((int) (x - 9), (int) (y + 3), (int) (z + 9))).getBlock(), (int) 60);
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) (x + 1), (int) (y + 3), (int) (z - 9)),
				world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 3), (int) (z - 9))).getBlock(), (int) 60);
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) (x + 5), (int) (y + 3), (int) (z - 9)),
				world.getBlockState(new BlockPos((int) (x + 5), (int) (y + 3), (int) (z - 9))).getBlock(), (int) 60);
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) (x + 9), (int) (y + 3), (int) (z - 9)),
				world.getBlockState(new BlockPos((int) (x + 9), (int) (y + 3), (int) (z - 9))).getBlock(), (int) 60);
	}
}
