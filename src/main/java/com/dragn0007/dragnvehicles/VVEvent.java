package com.dragn0007.dragnvehicles;

import com.dragn0007.dragnvehicles.registry.VehicleRegistry;
import com.dragn0007.dragnvehicles.vehicle.car.CarModel;
import com.dragn0007.dragnvehicles.vehicle.car.CarRender;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = ValiantVehiclesMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VVEvent {
    @SubscribeEvent
    public static void registerLayerDefinitionEvent(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CarRender.LAYER_LOCATION, CarModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRendererEvent(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(VehicleRegistry.CAR.get(), CarRender::new);
    }
}




