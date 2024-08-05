package com.dragn0007.dragnvehicles.registry;

import com.dragn0007.dragnvehicles.ValiantVehiclesMain;
import com.dragn0007.dragnvehicles.item.*;
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
    public static final RegistryObject<Item> SPORT_CAR_SPAWN_EGG = ITEMS.register("sport_car", SportCarItem::new);

    public static final RegistryObject<Item> CAR_BODY = ITEMS.register("car_body",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> CLASSIC_BODY = ITEMS.register("classic_body",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> TRUCK_BODY = ITEMS.register("truck_body",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> SUV_BODY = ITEMS.register("suv_body",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> SPORT_CAR_BODY = ITEMS.register("sport_car_body",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> WHEEL = ITEMS.register("wheel",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> SPORTS_WHEEL = ITEMS.register("sports_wheel",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> ENGINE = ITEMS.register("engine",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
}
