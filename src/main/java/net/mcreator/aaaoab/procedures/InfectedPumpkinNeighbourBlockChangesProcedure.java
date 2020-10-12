package net.mcreator.aaaoab.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.aaaoab.block.InfectedPumpkinBlock;
import net.mcreator.aaaoab.AaaoabModElements;

import java.util.Map;

@AaaoabModElements.ModElement.Tag
public class InfectedPumpkinNeighbourBlockChangesProcedure extends AaaoabModElements.ModElement {
	public InfectedPumpkinNeighbourBlockChangesProcedure(AaaoabModElements instance) {
		super(instance, 18);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure InfectedPumpkinNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure InfectedPumpkinNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure InfectedPumpkinNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure InfectedPumpkinNeighbourBlockChanges!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double offset = 0;
		offset = (double) 1;
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("deathTimer", ((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "deathTimer")) + 1));
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		for (int index0 = 0; index0 < (int) (2); index0++) {
			if (((Blocks.PUMPKIN.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) (x + (offset)), (int) y, (int) z)))
					.getBlock()) && (Math.random() >= 0.5))) {
				world.setBlockState(new BlockPos((int) (x + (offset)), (int) y, (int) z), InfectedPumpkinBlock.block.getDefaultState(), 3);
			}
			if (((Blocks.PUMPKIN.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y + (offset)), (int) z)))
					.getBlock()) && (Math.random() >= 0.5))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + (offset)), (int) z), InfectedPumpkinBlock.block.getDefaultState(), 3);
			}
			if (((Blocks.PUMPKIN.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + (offset)))))
					.getBlock()) && (Math.random() >= 0.5))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + (offset))), InfectedPumpkinBlock.block.getDefaultState(), 3);
			}
			if (((Blocks.PUMPKIN.getDefaultState()
					.getBlock() == (world.getBlockState(new BlockPos((int) (x - (offset)), (int) (y - 1), (int) (z - 1)))).getBlock())
					&& (Math.random() >= 0.5))) {
				world.setBlockState(new BlockPos((int) (x - (offset)), (int) (y - 1), (int) (z - 1)), InfectedPumpkinBlock.block.getDefaultState(),
						3);
			}
			if (((Blocks.PUMPKIN.getDefaultState()
					.getBlock() == (world.getBlockState(new BlockPos((int) (x - (offset)), (int) (y + 1), (int) (z + 1)))).getBlock())
					&& (Math.random() >= 0.5))) {
				world.setBlockState(new BlockPos((int) (x - (offset)), (int) (y + 1), (int) (z + 1)), InfectedPumpkinBlock.block.getDefaultState(),
						3);
			}
			if (((Blocks.PUMPKIN.getDefaultState()
					.getBlock() == (world.getBlockState(new BlockPos((int) (x - (offset)), (int) (y - 1), (int) (z + 1)))).getBlock())
					&& (Math.random() >= 0.5))) {
				world.setBlockState(new BlockPos((int) (x - (offset)), (int) (y - 1), (int) (z + 1)), InfectedPumpkinBlock.block.getDefaultState(),
						3);
			}
			if (((Blocks.PUMPKIN.getDefaultState()
					.getBlock() == (world.getBlockState(new BlockPos((int) (x - (offset)), (int) (y + 1), (int) (z - 1)))).getBlock())
					&& (Math.random() >= 0.5))) {
				world.setBlockState(new BlockPos((int) (x - (offset)), (int) (y + 1), (int) (z - 1)), InfectedPumpkinBlock.block.getDefaultState(),
						3);
			}
			if (((Blocks.PUMPKIN.getDefaultState()
					.getBlock() == (world.getBlockState(new BlockPos((int) (x - (offset)), (int) (y - 1), (int) (z - 1)))).getBlock())
					&& (Math.random() >= 0.5))) {
				world.setBlockState(new BlockPos((int) (x - (offset)), (int) (y - 1), (int) (z - 1)), InfectedPumpkinBlock.block.getDefaultState(),
						3);
			}
			if (((Blocks.PUMPKIN.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) (x - (offset)), (int) (y - 1), (int) z)))
					.getBlock()) && (Math.random() >= 0.5))) {
				world.setBlockState(new BlockPos((int) (x - (offset)), (int) (y - 1), (int) z), InfectedPumpkinBlock.block.getDefaultState(), 3);
			}
			if (((Blocks.PUMPKIN.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) (x - (offset)), (int) (y + 1), (int) z)))
					.getBlock()) && (Math.random() >= 0.5))) {
				world.setBlockState(new BlockPos((int) (x - (offset)), (int) (y + 1), (int) z), InfectedPumpkinBlock.block.getDefaultState(), 3);
			}
			if (((Blocks.PUMPKIN.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) (x - (offset)), (int) y, (int) (z - 1))))
					.getBlock()) && (Math.random() >= 0.5))) {
				world.setBlockState(new BlockPos((int) (x - (offset)), (int) y, (int) (z - 1)), InfectedPumpkinBlock.block.getDefaultState(), 3);
			}
			if (((Blocks.PUMPKIN.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) (x - (offset)), (int) y, (int) (z + 1))))
					.getBlock()) && (Math.random() >= 0.5))) {
				world.setBlockState(new BlockPos((int) (x - (offset)), (int) y, (int) (z + 1)), InfectedPumpkinBlock.block.getDefaultState(), 3);
			}
			if (((Blocks.PUMPKIN.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - (offset)))))
					.getBlock()) && (Math.random() >= 0.5))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - (offset))), InfectedPumpkinBlock.block.getDefaultState(), 3);
			}
			if (((Blocks.PUMPKIN.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - (offset)))))
					.getBlock()) && (Math.random() >= 0.5))) {
				world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - (offset))), InfectedPumpkinBlock.block.getDefaultState(), 3);
			}
			offset = (double) (-1);
		}
		if (((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "deathTimer")) >= 5)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.MELON.getDefaultState(), 3);
		}
	}
}
