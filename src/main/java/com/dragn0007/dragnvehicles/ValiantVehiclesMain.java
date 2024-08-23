package com.dragn0007.dragnvehicles;

import com.dragn0007.dragnvehicles.registry.ItemRegistry;
import com.dragn0007.dragnvehicles.registry.VehicleRegistry;
import com.mojang.logging.LogUtils;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DataSerializerEntry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import static com.dragn0007.dragnvehicles.ValiantVehiclesMain.MODID;

@Mod(MODID)
public class ValiantVehiclesMain
{
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "dragnvehicles";

    public static final DeferredRegister<DataSerializerEntry> SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.DATA_SERIALIZERS, MODID);
    public static final RegistryObject<DataSerializerEntry> RESOURCE_SERIALIZER = SERIALIZERS.register("resource_serializer", () -> new DataSerializerEntry(new EntityDataSerializer<ResourceLocation>() {
        @Override
        public void write(FriendlyByteBuf buf, ResourceLocation resourceLocation) {
            buf.writeResourceLocation(resourceLocation);
        }

        @Override
        public ResourceLocation read(FriendlyByteBuf buf) {
            return buf.readResourceLocation();
        }

        @Override
        public ResourceLocation copy(ResourceLocation resourceLocation) {
            return resourceLocation;
        }
    }));

    public ValiantVehiclesMain()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        SERIALIZERS.register(eventBus);
        ItemRegistry.ITEMS.register(eventBus);
        VehicleRegistry.ENTITY_TYPES.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(FMLClientSetupEvent event) {
    }

    public static float mod(float n, float m) {
        while(n < 0) {
            n += m;
        }
        return n % m;
    }
}