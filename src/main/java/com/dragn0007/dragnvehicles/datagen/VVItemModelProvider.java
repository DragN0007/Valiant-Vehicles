package com.dragn0007.dragnvehicles.datagen;

import com.dragn0007.dragnvehicles.ValiantVehiclesMain;
import com.dragn0007.dragnvehicles.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class VVItemModelProvider extends ItemModelProvider {
    public VVItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ValiantVehiclesMain.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ItemRegistry.CAR_SPAWN_EGG.get());
        simpleItem(ItemRegistry.CLASSIC_SPAWN_EGG.get());
        simpleItem(ItemRegistry.TRUCK_SPAWN_EGG.get());
        simpleItem(ItemRegistry.SUV_SPAWN_EGG.get());

        simpleItem(ItemRegistry.CAR_BODY.get());
        simpleItem(ItemRegistry.CLASSIC_BODY.get());
        simpleItem(ItemRegistry.TRUCK_BODY.get());
        simpleItem(ItemRegistry.SUV_BODY.get());
        simpleItem(ItemRegistry.WHEEL.get());
    }

    private ItemModelBuilder simpleItem(Item item) {
        return withExistingParent(item.getRegistryName().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ValiantVehiclesMain.MODID,"item/" + item.getRegistryName().getPath()));
    }
}