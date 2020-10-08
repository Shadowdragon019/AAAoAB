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

import net.mcreator.aaaoab.block.SupportGeneratorBlock;
import net.mcreator.aaaoab.AaaoabModElements;

import java.util.Map;

@AaaoabModElements.ModElement.Tag
public class SupportGeneratorBlockAddedProcedure extends AaaoabModElements.ModElement {
	public SupportGeneratorBlockAddedProcedure(AaaoabModElements instance) {
		super(instance, 13);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SupportGeneratorBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SupportGeneratorBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SupportGeneratorBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SupportGeneratorBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)).isSolid())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SupportGeneratorBlock.block.getDefaultState(), 3);
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("aaaoab", "spruce_support_bottom"));
				if (template != null) {
					template.addBlocksToWorld(world, new BlockPos((int) (x - 1), (int) y, (int) (z - 1)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		} else {
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), SupportGeneratorBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.SPRUCE_LOG.getDefaultState(), 3);
		}
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) (x + 4), (int) y, (int) z),
				world.getBlockState(new BlockPos((int) (x + 4), (int) y, (int) z)).getBlock(), (int) 0);
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) (x - 4), (int) y, (int) z),
				world.getBlockState(new BlockPos((int) (x - 4), (int) y, (int) z)).getBlock(), (int) 0);
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) x, (int) y, (int) (z + 4)),
				world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 4))).getBlock(), (int) 0);
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) x, (int) y, (int) (z - 4)),
				world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 4))).getBlock(), (int) 0);
	}
}
