package com.dragn0007.dragnvehicles.vehicle.motorcycle;// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.dragn0007.dragnvehicles.Animation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class MotorcycleModel<T extends Entity> extends EntityModel<Motorcycle> {

	private final ModelPart Body;
	private final ModelPart Handles;
	private final ModelPart FrontWheel;
	private final ModelPart BackWheel;

	public MotorcycleModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Handles = root.getChild("Handles");
		this.FrontWheel = root.getChild("FrontWheel");
		this.BackWheel = root.getChild("BackWheel");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 66).addBox(-6.0F, -5.0307F, -10.3582F, 12.0F, 15.0F, 19.0F, new CubeDeformation(0.0F))
				.texOffs(106, 91).addBox(-5.0F, -7.0307F, -10.3582F, 10.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(62, 85).addBox(-5.0F, -8.0307F, 8.6418F, 10.0F, 9.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(66, 60).addBox(-5.0F, -8.0307F, -26.3582F, 10.0F, 9.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(50, 135).addBox(-3.0F, -7.0307F, -28.3582F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0307F, 3.3582F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(42, 106).addBox(-4.0F, -8.5F, -8.0F, 8.0F, 18.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.3601F, 16.1182F, -1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 100).addBox(-1.0F, -2.0981F, -1.1699F, 6.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.7807F, 10.0748F, -0.8727F, 0.0F, 0.0F));

		PartDefinition cube_r3 = Body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(118, 60).addBox(-4.0F, -8.5F, -1.0F, 8.0F, 18.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.3601F, -17.8346F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r4 = Body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(126, 48).addBox(-8.0F, -5.5F, 0.0F, 16.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.3807F, -19.3582F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r5 = Body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 33).addBox(-8.0F, -2.0F, -13.0F, 4.0F, 4.0F, 29.0F, new CubeDeformation(0.0F))
				.texOffs(0, 33).addBox(4.0F, -2.0F, -13.0F, 4.0F, 4.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.9693F, 8.6418F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r6 = Body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(66, 0).addBox(-8.0F, -2.0F, -13.0F, 4.0F, 4.0F, 26.0F, new CubeDeformation(0.0F))
				.texOffs(66, 0).addBox(4.0F, -2.0F, -13.0F, 4.0F, 4.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.9693F, 6.6418F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Handles = partdefinition.addOrReplaceChild("Handles", CubeListBuilder.create().texOffs(106, 85).addBox(-12.0F, -2.5F, -1.5F, 24.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -10.5F));

		PartDefinition cube_r7 = Handles.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 100).addBox(-1.0F, -2.0981F, -13.8301F, 6.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 7.75F, 2.067F, 0.8727F, 0.0F, 0.0F));

		PartDefinition FrontWheel = partdefinition.addOrReplaceChild("FrontWheel", CubeListBuilder.create().texOffs(0, 119).addBox(-2.0F, -8.5F, -3.5F, 4.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.5F, -16.5F));

		PartDefinition cube_r8 = FrontWheel.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 119).addBox(-1.0F, -8.5F, -3.5F, 4.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r9 = FrontWheel.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 119).addBox(-1.0F, -8.5F, -3.5F, 4.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r10 = FrontWheel.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 119).addBox(-1.0F, -8.5F, -3.5F, 4.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

		PartDefinition BackWheel = partdefinition.addOrReplaceChild("BackWheel", CubeListBuilder.create().texOffs(0, 119).addBox(-2.0F, -8.5F, -3.5F, 4.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.5F, 21.5F));

		PartDefinition cube_r11 = BackWheel.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 119).addBox(-1.0F, -8.5F, -3.5F, 4.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r12 = BackWheel.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 119).addBox(-1.0F, -8.5F, -3.5F, 4.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r13 = BackWheel.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 119).addBox(-1.0F, -8.5F, -3.5F, 4.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		this.Handles.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		this.FrontWheel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		this.BackWheel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void prepareMobModel(Motorcycle motorcycle, float p_102615_, float p_102616_, float partialTick) {
		Animation.animate(this.Body, MotorcycleRender.BODY_ANIMATION, motorcycle.driveTick, motorcycle.lastDrivePartialTick, motorcycle.forwardMotion);
		Animation.animate(this.FrontWheel, MotorcycleRender.FRONT_WHEEL_ANIMATION, motorcycle.driveTick, motorcycle.lastDrivePartialTick, motorcycle.forwardMotion);
		Animation.animate(this.BackWheel, MotorcycleRender.BACK_WHEEL_ANIMATION, motorcycle.driveTick, motorcycle.lastDrivePartialTick, motorcycle.forwardMotion);
	}

	@Override
	public void setupAnim(Motorcycle motorcycle, float partialTick, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		motorcycle.updateLastDrivePartialTick(partialTick);
		Animation.animate(this.Body, MotorcycleRender.BODY_ANIMATION, motorcycle.driveTick, motorcycle.lastDrivePartialTick, motorcycle.forwardMotion);
		Animation.animate(this.FrontWheel, MotorcycleRender.FRONT_WHEEL_ANIMATION, motorcycle.driveTick, motorcycle.lastDrivePartialTick, motorcycle.forwardMotion);
		Animation.animate(this.BackWheel, MotorcycleRender.BACK_WHEEL_ANIMATION, motorcycle.driveTick, motorcycle.lastDrivePartialTick, motorcycle.forwardMotion);

		this.FrontWheel.yRot = motorcycle.getFrontWheelRotation(partialTick);
		this.Handles.yRot = motorcycle.getHandleRotation(partialTick);
	}
}