package com.dragn0007.dragnvehicles.registry;

import com.dragn0007.dragnvehicles.ValiantVehiclesMain;
import com.dragn0007.dragnvehicles.vehicle.car.Car;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VehicleRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ValiantVehiclesMain.MODID);


    public static final RegistryObject<EntityType<Car>> CAR = ENTITY_TYPES.register("car",
            () -> EntityType.Builder.of(Car::new, MobCategory.MISC).sized(2.8f, 2.8f).build
                    (new ResourceLocation(ValiantVehiclesMain.MODID, "car").toString()));

}
