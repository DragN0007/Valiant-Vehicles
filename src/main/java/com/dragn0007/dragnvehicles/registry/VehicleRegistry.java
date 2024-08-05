package com.dragn0007.dragnvehicles.registry;

import com.dragn0007.dragnvehicles.ValiantVehiclesMain;
import com.dragn0007.dragnvehicles.vehicle.car.Car;
import com.dragn0007.dragnvehicles.vehicle.classic.Classic;
import com.dragn0007.dragnvehicles.vehicle.sportcar.SportCar;
import com.dragn0007.dragnvehicles.vehicle.suv.SUV;
import com.dragn0007.dragnvehicles.vehicle.truck.Truck;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VehicleRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ValiantVehiclesMain.MODID);

    public static final RegistryObject<EntityType<Car>> CAR = ENTITY_TYPES.register("car",
            () -> EntityType.Builder.of(Car::new, MobCategory.MISC).sized(3f, 2.5f).build
                    (new ResourceLocation(ValiantVehiclesMain.MODID, "car").toString()));

    public static final RegistryObject<EntityType<Classic>> CLASSIC = ENTITY_TYPES.register("classic",
            () -> EntityType.Builder.of(Classic::new, MobCategory.MISC).sized(3f, 2.5f).build
                    (new ResourceLocation(ValiantVehiclesMain.MODID, "classic").toString()));

    public static final RegistryObject<EntityType<Truck>> TRUCK = ENTITY_TYPES.register("truck",
            () -> EntityType.Builder.of(Truck::new, MobCategory.MISC).sized(3f, 2.5f).build
                    (new ResourceLocation(ValiantVehiclesMain.MODID, "truck").toString()));

    public static final RegistryObject<EntityType<SUV>> SUV = ENTITY_TYPES.register("suv",
            () -> EntityType.Builder.of(SUV::new, MobCategory.MISC).sized(3f, 2.5f).build
                    (new ResourceLocation(ValiantVehiclesMain.MODID, "suv").toString()));

    public static final RegistryObject<EntityType<SportCar>> SPORT_CAR = ENTITY_TYPES.register("sport_car",
            () -> EntityType.Builder.of(SportCar::new, MobCategory.MISC).sized(3f, 2.2f).build
                    (new ResourceLocation(ValiantVehiclesMain.MODID, "sport_car").toString()));
}
