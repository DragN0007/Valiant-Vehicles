package com.dragn0007.dragnvehicles.datagen;

import com.dragn0007.dragnvehicles.registry.ItemRegistry;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class VVRecipeMaker extends RecipeProvider implements IConditionBuilder {
    public VVRecipeMaker(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        ShapedRecipeBuilder.shaped(ItemRegistry.CAR_SPAWN_EGG.get())
                .define('A', ItemRegistry.CAR_BODY.get())
                .define('B', ItemRegistry.WHEEL.get())
                .pattern(" A ")
                .pattern("B B")
                .pattern("B B")
                .unlockedBy("has_body", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ItemRegistry.CAR_BODY.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.CLASSIC_SPAWN_EGG.get())
                .define('A', ItemRegistry.CLASSIC_BODY.get())
                .define('B', ItemRegistry.WHEEL.get())
                .pattern(" A ")
                .pattern("B B")
                .pattern("B B")
                .unlockedBy("has_body", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ItemRegistry.CLASSIC_BODY.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.TRUCK_SPAWN_EGG.get())
                .define('A', ItemRegistry.TRUCK_BODY.get())
                .define('B', ItemRegistry.WHEEL.get())
                .pattern(" A ")
                .pattern("B B")
                .pattern("B B")
                .unlockedBy("has_body", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ItemRegistry.TRUCK_BODY.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.SUV_SPAWN_EGG.get())
                .define('A', ItemRegistry.SUV_BODY.get())
                .define('B', ItemRegistry.WHEEL.get())
                .pattern(" A ")
                .pattern("B B")
                .pattern("B B")
                .unlockedBy("has_body", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ItemRegistry.SUV_BODY.get()).build()))
                .save(pFinishedRecipeConsumer);


        ShapedRecipeBuilder.shaped(ItemRegistry.WHEEL.get())
                .define('A', Items.DRIED_KELP_BLOCK)
                .define('B', Items.IRON_INGOT)
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .unlockedBy("has_dried_kelp_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.DRIED_KELP_BLOCK).build()))
                .save(pFinishedRecipeConsumer);


        ShapedRecipeBuilder.shaped(ItemRegistry.CAR_BODY.get())
                .define('A', Items.IRON_BLOCK)
                .define('B', Items.CHEST)
                .define('C', Items.GLASS_PANE)
                .pattern("ACA")
                .pattern("AAB")
                .pattern("A A")
                .unlockedBy("has_iron_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.IRON_BLOCK).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.CLASSIC_BODY.get())
                .define('A', Items.IRON_BLOCK)
                .define('B', Items.CHEST)
                .define('C', Items.GLASS_PANE)
                .pattern("ACB")
                .pattern("A A")
                .unlockedBy("has_iron_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.IRON_BLOCK).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.TRUCK_BODY.get())
                .define('A', Items.IRON_BLOCK)
                .define('B', Items.CHEST)
                .define('C', Items.GLASS_PANE)
                .pattern("ACA")
                .pattern("AAB")
                .pattern("AAA")
                .unlockedBy("has_iron_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.IRON_BLOCK).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.SUV_BODY.get())
                .define('A', Items.IRON_BLOCK)
                .define('B', Items.CHEST)
                .define('C', Items.GLASS_PANE)
                .pattern("ACA")
                .pattern("ABB")
                .pattern("AAA")
                .unlockedBy("has_iron_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.IRON_BLOCK).build()))
                .save(pFinishedRecipeConsumer);
    }
}