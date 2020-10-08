package net.mcreator.aaaoab.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.aaaoab.AaaoabModElements;

import java.util.Map;

@AaaoabModElements.ModElement.Tag
public class PumpkinWizardOnEntityTickUpdateProcedure extends AaaoabModElements.ModElement {
	public PumpkinWizardOnEntityTickUpdateProcedure(AaaoabModElements instance) {
		super(instance, 20);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PumpkinWizardOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.isInWater())) {
			entity.setMotion((entity.getMotion().getX()), ((entity.getMotion().getY()) + 0.05), (entity.getMotion().getZ()));
		}
	}
}
