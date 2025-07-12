package com.marco.marcomod.datagen;

import com.marco.marcomod.block.ModBlocks;
import com.marco.marcomod.item.ModItemGroups;
import com.marco.marcomod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ZH_CN extends FabricLanguageProvider{


    public ZH_CN(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "zh_cn",registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.DARKNESS_CAKE,"黑暗蛋糕");

        translationBuilder.add(ModBlocks.MAGNET,"吸铁石");

        translationBuilder.add(ModItemGroups.MARCOITEMS,"Marco的物品");
    }
}
