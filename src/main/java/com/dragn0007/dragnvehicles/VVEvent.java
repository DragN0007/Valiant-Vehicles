package com.dragn0007.dragnvehicles;

import com.dragn0007.dragnvehicles.registry.VehicleRegistry;
import com.dragn0007.dragnvehicles.vehicle.car.CarModel;
import com.dragn0007.dragnvehicles.vehicle.car.CarRender;
import com.dragn0007.dragnvehicles.vehicle.classic.ClassicModel;
import com.dragn0007.dragnvehicles.vehicle.classic.ClassicRender;
import com.dragn0007.dragnvehicles.vehicle.sportcar.SportCar;
import com.dragn0007.dragnvehicles.vehicle.sportcar.SportCarModel;
import com.dragn0007.dragnvehicles.vehicle.sportcar.SportCarRender;
import com.dragn0007.dragnvehicles.vehicle.suv.SUVModel;
import com.dragn0007.dragnvehicles.vehicle.suv.SUVRender;
import com.dragn0007.dragnvehicles.vehicle.truck.TruckModel;
import com.dragn0007.dragnvehicles.vehicle.truck.TruckRender;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = ValiantVehiclesMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VVEvent {
    @SubscribeEvent
    public static void registerLayerDefinitionEvent(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CarRender.LAYER_LOCATION, CarModel::createBodyLayer);
        event.registerLayerDefinition(ClassicRender.LAYER_LOCATION, ClassicModel::createBodyLayer);
        event.registerLayerDefinition(TruckRender.LAYER_LOCATION, TruckModel::createBodyLayer);
        event.registerLayerDefinition(SUVRender.LAYER_LOCATION, SUVModel::createBodyLayer);
        event.registerLayerDefinition(SportCarRender.LAYER_LOCATION, SportCarModel::createBodyLayer);

    }

    @SubscribeEvent
    public static void registerRendererEvent(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(VehicleRegistry.CAR.get(), CarRender::new);
        event.registerEntityRenderer(VehicleRegistry.CLASSIC.get(), ClassicRender::new);
        event.registerEntityRenderer(VehicleRegistry.TRUCK.get(), TruckRender::new);
        event.registerEntityRenderer(VehicleRegistry.SUV.get(), SUVRender::new);
        event.registerEntityRenderer(VehicleRegistry.SPORT_CAR.get(), SportCarRender::new);
    }
}




