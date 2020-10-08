
package net.mcreator.aaaoab.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.Blocks;

import net.mcreator.aaaoab.AaaoabModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@AaaoabModElements.ModElement.Tag
public class SentientPumpkinEntity extends AaaoabModElements.ModElement {
	public static EntityType entity = null;
	public SentientPumpkinEntity(AaaoabModElements instance) {
		super(instance, 15);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.AMBIENT).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("sentient_pumpkin")
						.setRegistryName("sentient_pumpkin");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -26368, -39424, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("sentient_pumpkin"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("aaaoab:pumpkin_pastures")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("aaaoab:pumpkin_plains")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.AMBIENT).add(new Biome.SpawnListEntry(entity, 80, 1, 4));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelpumpkinCreative(), 0.75f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("aaaoab:textures/pumpking_creature_texture.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 3;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new TemptGoal(this, 1, Ingredient.fromItems(new ItemStack(Blocks.PUMPKIN, (int) (1)).getItem()), false));
			this.goalSelector.addGoal(2, new PanicGoal(this, 1.4));
			this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(Items.PUMPKIN_SEEDS, (int) (1)));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.pumpkin.carve"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.pumpkin.carve"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench 3.6.3
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelpumpkinCreative extends EntityModel<Entity> {
		private final ModelRenderer all;
		private final ModelRenderer rightLeg;
		private final ModelRenderer leftLeg;
		private final ModelRenderer rightArm;
		private final ModelRenderer leftArm;
		private final ModelRenderer body;
		public ModelpumpkinCreative() {
			textureWidth = 64;
			textureHeight = 64;
			all = new ModelRenderer(this);
			all.setRotationPoint(0.0F, 24.0F, 0.0F);
			rightLeg = new ModelRenderer(this);
			rightLeg.setRotationPoint(-4.0F, -4.0F, 0.0F);
			all.addChild(rightLeg);
			rightLeg.setTextureOffset(30, 32).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);
			leftLeg = new ModelRenderer(this);
			leftLeg.setRotationPoint(4.0F, -4.0F, 0.0F);
			all.addChild(leftLeg);
			leftLeg.setTextureOffset(34, 42).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);
			rightArm = new ModelRenderer(this);
			rightArm.setRotationPoint(-9.0F, -15.0F, 0.0F);
			all.addChild(rightArm);
			rightArm.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 6.0F, 6.0F, 0.0F, false);
			leftArm = new ModelRenderer(this);
			leftArm.setRotationPoint(9.0F, -15.0F, 0.0F);
			all.addChild(leftArm);
			leftArm.setTextureOffset(0, 45).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 6.0F, 6.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			all.addChild(body);
			body.setTextureOffset(0, 0).addBox(-8.0F, -20.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
			body.setTextureOffset(0, 32).addBox(-5.0F, -21.5F, -5.0F, 10.0F, 3.0F, 10.0F, 0.0F, false);
			body.setTextureOffset(16, 45).addBox(-1.5F, -27.5F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);
			body.setTextureOffset(48, 0).addBox(1.5F, -30.5F, 1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			all.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.all.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.all.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.leftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
