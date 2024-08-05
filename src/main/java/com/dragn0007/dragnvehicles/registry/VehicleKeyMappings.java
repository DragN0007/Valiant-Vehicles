package com.dragn0007.dragnvehicles.registry;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

public class VehicleKeyMappings {
    public static final KeyMapping DRIFT_KEY = new KeyMapping(
            "key.dragnvehicles.drift",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_SPACE,
            "key.categories.movement"
    );

    public static void register(final FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(DRIFT_KEY);
        MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
    }

    public static class KeyInputHandler {
        @SubscribeEvent
        public void onClientTick(TickEvent.ClientTickEvent event) {
            if (event.phase == TickEvent.Phase.END) {
                if (DRIFT_KEY.isDown()) {
                }
            }
        }
    }
}
