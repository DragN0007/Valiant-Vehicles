package com.dragn0007.dragnvehicles.vehicle;

import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.dragn0007.dragnvehicles.ValiantVehiclesMain.mod;

public class AbstractVehicle extends Entity {

    private static final float SPEED = 0.07f;
    private static final float TURN_SPEED = 1f;
    private static final float MAX_TURN = 5f;
    private static final float FRICTION = 0.7f;
    private static final float GRAVITY = 0.08f;


    private float targetRotation = 0;
    private float currentRotation = 0;

    private int tillerCooldown = 0;

    public int forwardMotion = 1;

    public int driveTick = 0;
    public float lastDrivePartialTick = 0;
    public Vec3 lastPos = Vec3.ZERO;

    public SimpleContainer inventory;
    private LazyOptional<?> itemHandler;

    private int lerpSteps;
    private double targetX;
    private double targetY;
    private double targetZ;
    private float targetYRot;

    public AbstractVehicle(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData() {

    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(this.isAlive() && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && this.itemHandler != null) {
            return itemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        if(this.itemHandler != null) {
            LazyOptional<?> oldHandler = this.itemHandler;
            this.itemHandler = null;
            oldHandler.invalidate();
        }
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag p_20052_) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag p_20139_) {

    }

    private Vec3 calcOffset(double x, double y, double z) {
        double rad = this.getYRot() * Math.PI / 180;

        double xOffset = this.position().x + (x * Math.cos(rad) - z * Math.sin(rad));
        double yOffset = this.position().y + y;
        double zOffset = this.position().z + (x * Math.sin(rad) + z * Math.cos(rad));

        return new Vec3(xOffset, yOffset, zOffset);
    }

    public void updateLastDrivePartialTick(float partialTick) {
        double xStep = this.position().x - this.lastPos.x;
        double zStep = this.position().z - this.lastPos.z;

        if(xStep * xStep + zStep * zStep != 0) {
            this.lastDrivePartialTick = partialTick;
        }
    }

    public void calcAnimStep() {
        double xStep = this.position().x - this.lastPos.x;
        double zStep = this.position().z - this.lastPos.z;
        float deg = (float) (Math.atan2(xStep, zStep) * 180 / Math.PI);

        if(xStep * xStep + zStep * zStep != 0) {
            this.driveTick = (this.driveTick + 1) % 30; // dragoon this 30 number is hardcoded I will come up with something better when I work on ME or something idk who cares it took like 2 seconds to figure out
            this.forwardMotion = (Math.round(mod(this.getYRot(), 360) + deg) == 180) ? -1 : 1;
        }
    }

    @Override
    public void positionRider(Entity entity) {
        if(this.hasPassenger(entity)) {
            entity.setPos(this.calcOffset(0, 0.8, -0.5));
        }
    }

    @Nullable
    @Override
    public Entity getControllingPassenger() {
        return this.getFirstPassenger();
    }

    @Override
    public void lerpTo(double x, double y, double z, float yRot, float xRot, int lerpSteps, boolean p_19902_) {
        this.targetX = x;
        this.targetY = y;
        this.targetZ = z;
        this.targetYRot = yRot;

        this.lerpSteps = lerpSteps;
    }

    @Override
    public float getStepHeight() {
        return 1;
    }

    private void handleInput(Input input) {
        float forward = 0;
        float turn = 0;
        int turnMod = 1;

        if(input.up) {
            forward = SPEED;
        }

        if(input.down) {
            forward = -SPEED;
            turnMod = -1;
        }

        if(input.left) {
            turn = -TURN_SPEED * turnMod;
        }

        if(input.right) {
            turn = TURN_SPEED * turnMod;
        }

        this.currentRotation = this.targetRotation;
        if(Math.abs(this.targetRotation + turn) <= MAX_TURN) {
            this.targetRotation += turn;
        }

        if(forward != 0 && turn == 0) {
            this.targetRotation = 0;
        }

        float deg = this.currentRotation + this.getYRot();
        float rad = deg * (float)Math.PI / 180;

        if(forward != 0 && deg != this.getYRot()) {
            this.setYRot(deg);
        }

        this.setDeltaMovement(this.getDeltaMovement().add(-Math.sin(rad) * forward, 0, Math.cos(rad) * forward));
    }

    @Override
    public void tick() {
        super.tick();
        this.lastPos = this.position();
        if(this.isControlledByLocalInstance()) {
            this.lerpSteps = 0;
            this.setPacketCoordinates(this.getX(), this.getY(), this.getZ());
            this.setDeltaMovement(this.getDeltaMovement().multiply(FRICTION, 1, FRICTION).add(0, this.onGround ? 0 : -GRAVITY, 0));

            if(this.getDeltaMovement().length() < 0.01) {
                this.setDeltaMovement(Vec3.ZERO);
            }

            if(this.getControllingPassenger() instanceof LocalPlayer player) {
                this.handleInput(player.input);
            }
            this.move(MoverType.SELF, this.getDeltaMovement());
        } else {
            this.setDeltaMovement(Vec3.ZERO);
        }

        if(!this.level.isClientSide) {

            if (this.isUnderWater()) {
                this.hurt(DamageSource.DROWN, 1);
                this.ejectPassengers();
            }
        }

        if (this.lerpSteps > 0) {
            double x = this.getX() + (this.targetX - this.getX()) / this.lerpSteps;
            double y = this.getY() + (this.targetY - this.getY()) / this.lerpSteps;
            double z = this.getZ() + (this.targetZ - this.getZ()) / this.lerpSteps;

            float yRot = this.getYRot() + (this.targetYRot - this.getYRot()) / this.lerpSteps;

            this.setPos(x, y, z);
            this.setYRot(yRot);
            this.lerpSteps--;
        }

        this.calcAnimStep();
    }

    public float getFrontWheelRotation(float time) {
        return (this.currentRotation + (this.targetRotation - this.currentRotation) * time) * (float)Math.PI / 180;
    }

    @Override
    @NotNull
    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }
}
