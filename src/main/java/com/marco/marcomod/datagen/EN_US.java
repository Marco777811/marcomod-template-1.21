package com.marco.marcomod.datagen;

import com.marco.marcomod.block.ModBlocks;
import com.marco.marcomod.item.ModItemGroups;
import com.marco.marcomod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class EN_US extends FabricLanguageProvider{


    public EN_US(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us",registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.DARKNESS_CAKE,"darkness_cake");

        translationBuilder.add(ModBlocks.MAGNET,"Magnet");

        translationBuilder.add(ModItemGroups.MARCOITEMS,"Marco's item");
    }
}
