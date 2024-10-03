package com.dragn0007.dragnvehicles.vehicle.sportcar;


import com.dragn0007.dragnvehicles.Animation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class SportCarModel extends EntityModel<SportCar> {
	private final ModelPart Body;
	private final ModelPart FrontWheels;
	private final ModelPart BackWheels;

	public SportCarModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.FrontWheels = root.getChild("FrontWheels");
		this.BackWheels = root.getChild("BackWheels");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(2, 2).addBox(-22.0F, -11.0F, -45.0F, 44.0F, 4.0F, 100.0F, new CubeDeformation(0.0F))
				.texOffs(0, 249).addBox(-19.0F, -12.0F, 15.0F, 38.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(0, 68).addBox(-19.0F, -25.0F, 29.0F, 38.0F, 15.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 108).addBox(3.0F, -12.0F, -9.0F, 16.0F, 2.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(80, 140).addBox(3.0F, -25.0F, 8.0F, 16.0F, 15.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(80, 120).addBox(-19.0F, -12.0F, -9.0F, 16.0F, 2.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(117, 140).addBox(-19.0F, -25.0F, 8.0F, 16.0F, 15.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(31, 86).addBox(17.0F, -22.1242F, 27.8423F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(194, 3).addBox(19.5F, -35.0F, -16.0F, 0.0F, 12.0F, 58.0F, new CubeDeformation(0.0F))
				.texOffs(177, 162).addBox(-19.5F, -35.0F, -16.0F, 0.0F, 12.0F, 58.0F, new CubeDeformation(0.0F))
				.texOffs(0, 86).addBox(-23.0F, -22.1242F, 27.8423F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(236, 192).addBox(-23.0F, -22.1242F, -25.1577F, 46.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(161, 109).addBox(-20.0F, -23.0F, -43.0F, 40.0F, 15.0F, 34.0F, new CubeDeformation(0.0F))
				.texOffs(80, 124).addBox(19.0F, -23.0F, -21.0F, 2.0F, 15.0F, 75.0F, new CubeDeformation(0.0F))
				.texOffs(72, 199).addBox(19.0F, -34.6F, 9.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(93, 81).addBox(-19.975F, -34.6F, 25.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(58, 199).addBox(-20.0F, -34.6F, 9.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(65, 199).addBox(18.975F, -34.6F, 25.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 108).addBox(-21.0F, -23.0F, -21.0F, 2.0F, 15.0F, 75.0F, new CubeDeformation(0.0F))
				.texOffs(236, 159).addBox(-19.0F, -23.0F, 36.0F, 38.0F, 15.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(305, 99).mirror().addBox(-19.0F, -30.6F, 51.3F, 38.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(332, 105).mirror().addBox(19.0F, -31.6F, 51.3F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(332, 105).addBox(-21.0F, -31.6F, 51.3F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(1, 129).addBox(-13.0F, -23.0F, -44.0F, 26.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 215).addBox(-20.0F, -37.5255F, -2.9056F, 40.0F, 3.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 27.0F, -3.0F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(37, 0).addBox(-20.0F, -4.5F, 4.5F, 3.0F, 3.0F, 26.0F, new CubeDeformation(0.0F))
				.texOffs(37, 34).addBox(17.0F, -4.5F, 4.5F, 3.0F, 3.0F, 26.0F, new CubeDeformation(0.0F))
				.texOffs(191, 74).addBox(-19.0F, -3.6F, 4.4F, 38.0F, 0.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.5F, -23.5F, 0.6981F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-20.0F, -1.4977F, -14.7787F, 3.0F, 3.0F, 30.0F, new CubeDeformation(0.0F))
				.texOffs(0, 34).addBox(17.0F, -1.4977F, -14.7787F, 3.0F, 3.0F, 30.0F, new CubeDeformation(0.0F))
				.texOffs(113, 233).addBox(-17.0F, -0.0023F, -14.2213F, 34.0F, 0.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -26.9178F, 37.3616F, -0.6981F, 0.0F, 0.0F));

		PartDefinition cube_r3 = Body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(321, 105).mirror().addBox(16.0F, -1.25F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(321, 105).addBox(-18.0F, -1.25F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.75F, 52.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r4 = Body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(210, 233).addBox(-15.0F, -1.5F, 0.0F, 30.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, -43.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r5 = Body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(182, 187).addBox(-23.0F, -30.3F, -23.5F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(27, 199).addBox(17.0F, -30.3F, -23.5F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.5F, 59.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r6 = Body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(62, 86).addBox(-23.0F, -2.5F, -16.0F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(160, 184).addBox(17.0F, -2.5F, -16.0F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.5F, 47.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r7 = Body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(236, 204).addBox(-23.0F, -30.3F, -23.5F, 46.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.5F, 6.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r8 = Body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(80, 108).addBox(-23.0F, -2.5F, -16.0F, 46.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.5F, -6.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition FrontWheels = partdefinition.addOrReplaceChild("FrontWheels", CubeListBuilder.create().texOffs(187, 159).addBox(13.0F, -8.5F, -3.5F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(187, 159).addBox(-27.0F, -8.5F, -3.5F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(253, 11).addBox(-26.5F, -2.5F, -2.5F, 45.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 15.5F, -23.5F));

		PartDefinition cube_r9 = FrontWheels.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(187, 159).addBox(-2.0F, -8.5F, -3.5F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(187, 159).addBox(-42.0F, -8.5F, -3.5F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r10 = FrontWheels.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(187, 159).addBox(-2.0F, -8.5F, -3.5F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(187, 159).addBox(-42.0F, -8.5F, -3.5F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r11 = FrontWheels.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(187, 159).addBox(-2.0F, -8.5F, -3.5F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(187, 159).addBox(-42.0F, -8.5F, -3.5F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

		PartDefinition BackWheels = partdefinition.addOrReplaceChild("BackWheels", CubeListBuilder.create().texOffs(187, 159).addBox(13.0F, -8.5F, -3.5F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(187, 159).addBox(-27.0F, -8.5F, -3.5F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(253, 0).addBox(-26.4F, -2.5F, -2.5F, 45.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 15.5F, 29.5F));

		PartDefinition cube_r12 = BackWheels.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(187, 159).addBox(-2.0F, -8.5F, -3.5F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(187, 159).addBox(-42.0F, -8.5F, -3.5F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r13 = BackWheels.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(187, 159).addBox(-2.0F, -8.5F, -3.5F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(187, 159).addBox(-42.0F, -8.5F, -3.5F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r14 = BackWheels.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(187, 159).addBox(-2.0F, -8.5F, -3.5F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(187, 159).addBox(-42.0F, -8.5F, -3.5F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		this.FrontWheels.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		this.BackWheels.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void prepareMobModel(SportCar car, float p_102615_, float p_102616_, float partialTick) {
		Animation.animate(this.Body, SportCarRender.BODY_ANIMATION, car.driveTick, car.lastDrivePartialTick, car.forwardMotion);
		Animation.animate(this.FrontWheels, SportCarRender.FRONT_WHEEL_ANIMATION, car.driveTick, car.lastDrivePartialTick, car.forwardMotion);
		Animation.animate(this.BackWheels, SportCarRender.BACK_WHEEL_ANIMATION, car.driveTick, car.lastDrivePartialTick, car.forwardMotion);
	}

	@Override
	public void setupAnim(SportCar car, float partialTick, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		car.updateLastDrivePartialTick(partialTick);
		Animation.animate(this.Body, SportCarRender.BODY_ANIMATION, car.driveTick, car.lastDrivePartialTick, car.forwardMotion);
		Animation.animate(this.FrontWheels, SportCarRender.FRONT_WHEEL_ANIMATION, car.driveTick, car.lastDrivePartialTick, car.forwardMotion);
		Animation.animate(this.BackWheels, SportCarRender.BACK_WHEEL_ANIMATION, car.driveTick, car.lastDrivePartialTick, car.forwardMotion);

		this.FrontWheels.yRot = car.getFrontWheelRotation(partialTick);
	}
}