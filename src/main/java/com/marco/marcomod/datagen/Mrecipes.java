package com.marco.marcomod.datagen;

import com.marco.marcomod.MarcoMod;
import com.marco.marcomod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Mrecipes extends FabricRecipeProvider {
    private static final List<ItemConvertible> WATER = List.of(Items.POWDER_SNOW_BUCKET);
    public Mrecipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        offerSmelting(recipeExporter,WATER, RecipeCategory.MISC,Items.WATER_BUCKET,0.0f,100,"water_bucket");

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MAGNET,2)
                .pattern("###")
                .pattern("#A#")
                .pattern("###")
                .input('#', Ingredient.ofItems(Items.IRON_INGOT))
                .input('A',Ingredient.ofItems(Items.IRON_BLOCK))
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.IRON_BLOCK))
                .criterion("has_item",RecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .offerTo(recipeExporter, Identifier.of(MarcoMod.MOD_ID,"make_magnet"));
    }
}
