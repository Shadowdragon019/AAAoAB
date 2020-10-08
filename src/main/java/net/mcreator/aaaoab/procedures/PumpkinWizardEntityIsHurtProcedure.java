package net.mcreator.aaaoab.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.aaaoab.entity.PumpkinBombEntity;
import net.mcreator.aaaoab.AaaoabModElements;

import java.util.Map;

@AaaoabModElements.ModElement.Tag
public class PumpkinWizardEntityIsHurtProcedure extends AaaoabModElements.ModElement {
	public PumpkinWizardEntityIsHurtProcedure(AaaoabModElements instance) {
		super(instance, 24);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PumpkinWizardEntityIsHurt!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PumpkinWizardEntityIsHurt!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PumpkinWizardEntityIsHurt!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PumpkinWizardEntityIsHurt!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double randomNum = 0;
		randomNum = (double) Math.round((Math.random() * 3));
		if (((randomNum) == 0)) {
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new PumpkinBombEntity.CustomEntity(PumpkinBombEntity.entity, world.getWorld());
				entityToSpawn.setLocationAndAngles((x + ((Math.random() * (-8)) + 4)), y, (z + ((Math.random() * (-8)) + 4)),
						world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
		} else if (((randomNum) == 1)) {
			for (int index0 = 0; index0 < (int) (Math.round((Math.random() + 2))); index0++) {
				if (world instanceof World && !world.getWorld().isRemote) {
					Entity entityToSpawn = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world.getWorld());
					entityToSpawn.setLocationAndAngles((x + ((Math.random() * (-8)) + 4)), y, (z + ((Math.random() * (-8)) + 4)),
							world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
