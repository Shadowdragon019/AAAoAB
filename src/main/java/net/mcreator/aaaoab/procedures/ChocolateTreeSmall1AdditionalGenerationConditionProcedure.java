package net.mcreator.aaaoab.procedures;

import net.mcreator.aaaoab.AaaoabModElements;

import java.util.Map;

@AaaoabModElements.ModElement.Tag
public class ChocolateTreeSmall1AdditionalGenerationConditionProcedure extends AaaoabModElements.ModElement {
	public ChocolateTreeSmall1AdditionalGenerationConditionProcedure(AaaoabModElements instance) {
		super(instance, 52);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure ChocolateTreeSmall1AdditionalGenerationCondition!");
			return false;
		}
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		if ((y >= 114)) {
			return (true);
		}
		return (false);
	}
}
