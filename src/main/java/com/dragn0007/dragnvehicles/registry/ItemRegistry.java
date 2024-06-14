package com.dragn0007.dragnvehicles.registry;

import com.dragn0007.dragnvehicles.ValiantVehiclesMain;
import com.dragn0007.dragnvehicles.item.CarItem;
import com.dragn0007.dragnvehicles.item.ClassicItem;
import com.dragn0007.dragnvehicles.item.SUVItem;
import com.dragn0007.dragnvehicles.item.TruckItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ValiantVehiclesMain.MODID);

    public static final RegistryObject<Item> CAR_SPAWN_EGG = ITEMS.register("car", CarItem::new);
    public static final RegistryObject<Item> CLASSIC_SPAWN_EGG = ITEMS.register("classic", ClassicItem::new);
    public static final RegistryObject<Item> TRUCK_SPAWN_EGG = ITEMS.register("truck", TruckItem::new);
    public static final RegistryObject<Item> SUV_SPAWN_EGG = ITEMS.register("suv", SUVItem::new);

    public static final RegistryObject<Item> CAR_BODY = ITEMS.register("car_body",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> CLASSIC_BODY = ITEMS.register("classic_body",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> TRUCK_BODY = ITEMS.register("truck_body",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> SUV_BODY = ITEMS.register("suv_body",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> WHEEL = ITEMS.register("wheel",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
}
