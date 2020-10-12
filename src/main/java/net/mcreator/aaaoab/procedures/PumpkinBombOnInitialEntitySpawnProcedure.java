package net.mcreator.aaaoab.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.aaaoab.AaaoabModElements;

import java.util.Map;

@AaaoabModElements.ModElement.Tag
public class PumpkinBombOnInitialEntitySpawnProcedure extends AaaoabModElements.ModElement {
	public PumpkinBombOnInitialEntitySpawnProcedure(AaaoabModElements instance) {
		super(instance, 22);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PumpkinBombOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("bombTimer", 0);
	}
}
