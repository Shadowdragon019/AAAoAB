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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		all.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.all.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.all.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.leftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}