package com.dragn0007.dragnvehicles.vehicle.car;

import com.dragn0007.dragnvehicles.Animation;
import com.dragn0007.dragnvehicles.ValiantVehiclesMain;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CarRender extends EntityRenderer<Car> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ValiantVehiclesMain.MODID, "car"), "main");

    public static final Animation BODY_ANIMATION = new Animation(1.5f, new Animation.KeyFrame[]{
            new Animation.KeyFrame(0f, 0f, 0f, 0f),
            new Animation.KeyFrame(0.375f, 1f, 0f, -1f),
            new Animation.KeyFrame(0.75f, 0f, 0f, 0f),
            new Animation.KeyFrame(1.125f, 1f, 0f, 1f),
            new Animation.KeyFrame(1.5f, 0f, 0f, 0f),
    });

    public static final Animation FRONT_WHEEL_ANIMATION = new Animation(1.5f, new Animation.KeyFrame[]{
            new Animation.KeyFrame(0f, 0f, 0f, 0f),
            new Animation.KeyFrame(1.5f, 360f, 0f, 0f)
    });

    public static final Animation BACK_WHEEL_ANIMATION = new Animation(1.5f, new Animation.KeyFrame[]{
            new Animation.KeyFrame(0f, 0f, 0f, 0f),
            new Animation.KeyFrame(1.5f, 360f, 0f, 0f)
    });



    private final CarModel model;

    public CarRender(EntityRendererProvider.Context context) {
        super(context);
        this.model = new CarModel(context.bakeLayer(LAYER_LOCATION));
    }

    @Override
    public void render(Car car, float rotation, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();

        poseStack.scale(-1, -1, 1);
        poseStack.translate(0, -1.5, 0);

        poseStack.mulPose(Vector3f.YP.rotationDegrees(rotation - 180));
        this.model.prepareMobModel(car, 0, 0, partialTick);
        this.model.setupAnim(car, partialTick, 0, 0, 0, 0);

        VertexConsumer vertexConsumer = bufferSource.getBuffer(this.model.renderType(car.getTextureLocation()));
        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);

        poseStack.popPose();
        super.render(car, rotation, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    @NotNull
    public ResourceLocation getTextureLocation(Car car) {
        return car.getTextureLocation();
    }
}

