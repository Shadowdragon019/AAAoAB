package net.mcreator.aaaoab.procedures;

import net.mcreator.aaaoab.AaaoabModElements;

import java.util.Map;

@AaaoabModElements.ModElement.Tag
public class ChocolateTreeNormalAdditionalGenerationConditionProcedure extends AaaoabModElements.ModElement {
	public ChocolateTreeNormalAdditionalGenerationConditionProcedure(AaaoabModElements instance) {
		super(instance, 54);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure ChocolateTreeNormalAdditionalGenerationCondition!");
			return false;
		}
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		if ((y <= 135)) {
			return (true);
		}
		return (false);
	}
}
