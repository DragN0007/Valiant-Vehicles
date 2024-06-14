package com.dragn0007.dragnvehicles.vehicle.car;

import com.dragn0007.dragnvehicles.ValiantVehiclesMain;
import com.dragn0007.dragnvehicles.item.CarItem;
import com.dragn0007.dragnvehicles.registry.ItemRegistry;
import com.dragn0007.dragnvehicles.vehicle.AbstractVehicle;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Car extends AbstractVehicle {

    private static final EntityDataAccessor<ResourceLocation> TEXTURE = (EntityDataAccessor<ResourceLocation>) SynchedEntityData.defineId(Car.class, ValiantVehiclesMain.RESOURCE_SERIALIZER.get().getSerializer());

    private static final ResourceLocation DEFAULT_TEXTURE = new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/.png");

    private static final float MAX_HEALTH = 20f;

    private static final Map<DyeItem, ResourceLocation> COLOR_MAP = new HashMap<>() {{
        put(DyeItem.byColor(DyeColor.BLACK), new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/black.png"));
        put(DyeItem.byColor(DyeColor.BLUE), new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/blue.png"));
        put(DyeItem.byColor(DyeColor.BROWN), new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/brown.png"));
        put(DyeItem.byColor(DyeColor.CYAN), new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/cyan.png"));
        put(DyeItem.byColor(DyeColor.GRAY), new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/dark_grey.png"));
        put(DyeItem.byColor(DyeColor.LIGHT_BLUE), new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/light_blue.png"));
        put(DyeItem.byColor(DyeColor.LIGHT_GRAY), new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/light_grey.png"));
        put(DyeItem.byColor(DyeColor.LIME), new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/lime_green.png"));
        put(DyeItem.byColor(DyeColor.MAGENTA), new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/magenta.png"));
        put(DyeItem.byColor(DyeColor.ORANGE), new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/orange.png"));
        put(DyeItem.byColor(DyeColor.PINK), new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/pink.png"));
        put(DyeItem.byColor(DyeColor.PURPLE), new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/purple.png"));
        put(DyeItem.byColor(DyeColor.RED), new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/red.png"));
        put(DyeItem.byColor(DyeColor.WHITE), new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/white.png"));
        put(DyeItem.byColor(DyeColor.GREEN), new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/green.png"));
        put(DyeItem.byColor(DyeColor.YELLOW), new ResourceLocation(ValiantVehiclesMain.MODID, "textures/entity/yellow.png"));
    }};
    
    
    private static final EntityDataAccessor<Float> HEALTH = SynchedEntityData.defineId(Car.class, EntityDataSerializers.FLOAT);

    public Car(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public boolean hurt(DamageSource damageSource, float damage) {
        if(!this.level.isClientSide && !this.isRemoved()) {
            this.markHurt();
            this.gameEvent(GameEvent.ENTITY_DAMAGED, damageSource.getEntity());
            float health = this.entityData.get(HEALTH) - damage;
            this.entityData.set(HEALTH, health);

            if(health < 0) {
                Containers.dropContents(this.level, this, this.inventory);
                this.spawnAtLocation(ItemRegistry.CAR_SPAWN_EGG.get());
                this.kill();
            }
        }
        return true;
    }


    @Override
    @NotNull
    public InteractionResult interact(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if(player.isShiftKeyDown()) {
            if(itemStack.getItem() instanceof DyeItem dyeItem) {
                this.level.playSound(player, this, SoundEvents.DYE_USE, SoundSource.PLAYERS, 1f, 1f);

                if (!this.level.isClientSide) {
                    this.entityData.set(TEXTURE, COLOR_MAP.get(dyeItem));
                    itemStack.shrink(1);
                }

                return InteractionResult.sidedSuccess(this.level.isClientSide);
            } else {
                if(!this.level.isClientSide) {
                    NetworkHooks.openGui((ServerPlayer) player, new SimpleMenuProvider((containerId, inventory, serverPlayer) -> {
                        return ChestMenu.sixRows(containerId, inventory, this.inventory);
                    }, this.getDisplayName()));
                }
            }
        } else if(!this.level.isClientSide){
            return player.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
        }
        return super.interact(player, hand);
    }

    public ResourceLocation getTextureLocation() {
        return this.entityData.get(TEXTURE);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(TEXTURE, DEFAULT_TEXTURE);
        this.entityData.define(HEALTH, MAX_HEALTH);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        ResourceLocation texture = ResourceLocation.tryParse(compoundTag.getString("Texture"));
        this.entityData.set(TEXTURE, texture == null ? DEFAULT_TEXTURE : texture);
        this.entityData.set(HEALTH, compoundTag.getFloat("Health"));

        ListTag listTag = compoundTag.getList("Items", 10);
        for(int i = 0; i < listTag.size(); i++) {
            CompoundTag tag = listTag.getCompound(i);
            int j = compoundTag.getByte("Slot") & 255;
            if(j < this.inventory.getContainerSize()) {
                this.inventory.setItem(j, ItemStack.of(tag));
            }
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putString("Texture", this.entityData.get(TEXTURE).toString());
        compoundTag.putFloat("Health", this.entityData.get(HEALTH));

        ListTag listTag = new ListTag();
        for(int i = 0; i < this.inventory.getContainerSize(); i++) {
            ItemStack itemStack = this.inventory.getItem(i);
            if(!itemStack.isEmpty()) {
                CompoundTag tag = new CompoundTag();
                tag.putByte("Slot", (byte) i);
                itemStack.save(tag);
                listTag.add(tag);
            }
        }
        compoundTag.put("Items", listTag);
    }

}
