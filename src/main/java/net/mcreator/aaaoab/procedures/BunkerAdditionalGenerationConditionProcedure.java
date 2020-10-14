package net.mcreator.aaaoab.procedures;

import net.minecraftforge.common.BiomeDictionary;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.aaaoab.AaaoabModElements;

import java.util.Map;

@AaaoabModElements.ModElement.Tag
public class BunkerAdditionalGenerationConditionProcedure extends AaaoabModElements.ModElement {
	public BunkerAdditionalGenerationConditionProcedure(AaaoabModElements instance) {
		super(instance, 44);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BunkerAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BunkerAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BunkerAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BunkerAdditionalGenerationCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((BiomeDictionary.hasType(world.getBiome(new BlockPos((int) x, (int) y, (int) z)), BiomeDictionary.Type.PLAINS))) {
			return (true);
		}
		return (false);
	}
}
