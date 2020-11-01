package net.mcreator.aaaoab.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.aaaoab.entity.PumpkinBombEntity;
import net.mcreator.aaaoab.AaaoabModElements;

import java.util.Map;
import java.util.Comparator;

@AaaoabModElements.ModElement.Tag
public class PumpkinWizardEntityIsHurtProcedure extends AaaoabModElements.ModElement {
	public PumpkinWizardEntityIsHurtProcedure(AaaoabModElements instance) {
		super(instance, 24);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PumpkinWizardEntityIsHurt!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure PumpkinWizardEntityIsHurt!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure PumpkinWizardEntityIsHurt!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure PumpkinWizardEntityIsHurt!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure PumpkinWizardEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double randomNum = 0;
		randomNum = (double) Math.round((Math.random() * 7));
		if (((randomNum) == 0)) {
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new PumpkinBombEntity.CustomEntity(PumpkinBombEntity.entity, world.getWorld());
				entityToSpawn.setLocationAndAngles(((entity.getPosX()) + ((Math.random() * (-8)) + 4)), (entity.getPosY()),
						((entity.getPosZ()) + ((Math.random() * (-8)) + 4)), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
		} else if (((randomNum) == 1)) {
			if ((!((world
					.getEntitiesWithinAABB(WitherSkeletonEntity.class,
							new AxisAlignedBB(x - 2 / 2, y - 2 / 2, z - 2 / 2, x + 2 / 2, y + 2 / 2, z + 2 / 2), null)
					.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)) != null))) {
				for (int index0 = 0; index0 < (int) (Math.round((Math.random() + 2))); index0++) {
					if (world instanceof World && !world.getWorld().isRemote) {
						Entity entityToSpawn = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world.getWorld());
						entityToSpawn.setLocationAndAngles(((entity.getPosX()) + ((Math.random() * (-8)) + 4)), (entity.getPosY()),
								((entity.getPosZ()) + ((Math.random() * (-8)) + 4)), world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
									SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
				}
			}
		} else if (((randomNum) == 2)) {
			entity.setMotion((entity.getMotion().getX()), 1, (entity.getMotion().getZ()));
			if (world instanceof World && !world.getWorld().isRemote) {
				world.getWorld().createExplosion(null, (int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ()), (float) 1,
						Explosion.Mode.BREAK);
			}
			if ((0 == ((new java.util.Random()).nextInt((int) 1 + 1)))) {
				if ((world.getWorld().isDaytime())) {
					for (int index1 = 0; index1 < (int) (Math.round((Math.random() + 2))); index1++) {
						if (world instanceof World && !world.getWorld().isRemote) {
							Entity entityToSpawn = new VexEntity(EntityType.VEX, world.getWorld());
							entityToSpawn.setLocationAndAngles((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
									world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
										SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
					}
				} else {
					for (int index2 = 0; index2 < (int) (Math.round((Math.random() + 2))); index2++) {
						if (world instanceof World && !world.getWorld().isRemote) {
							Entity entityToSpawn = new PhantomEntity(EntityType.PHANTOM, world.getWorld());
							entityToSpawn.setLocationAndAngles((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
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
	}
}
