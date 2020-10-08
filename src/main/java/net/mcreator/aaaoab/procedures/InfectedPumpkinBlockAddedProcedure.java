package net.mcreator.aaaoab.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.BlockState;

import net.mcreator.aaaoab.AaaoabModElements;

import java.util.Map;

@AaaoabModElements.ModElement.Tag
public class InfectedPumpkinBlockAddedProcedure extends AaaoabModElements.ModElement {
	public InfectedPumpkinBlockAddedProcedure(AaaoabModElements instance) {
		super(instance, 17);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure InfectedPumpkinBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure InfectedPumpkinBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure InfectedPumpkinBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure InfectedPumpkinBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("deathTimer", 0);
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
	}
}
