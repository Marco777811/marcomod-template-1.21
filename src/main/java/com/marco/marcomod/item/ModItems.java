package com.marco.marcomod.item;

import com.marco.marcomod.MarcoMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DARKNESS_CAKE = registerItems("darkness_cake",new Item(new Item.Settings().food(ModFoodComponents.DARKNESS_CAKE)));

    private static Item registerItems(String id, Item item){
        return Registry.register(Registries.ITEM,Identifier.of(MarcoMod.MOD_ID,id),item);
    }

    private static void addItemGroup(FabricItemGroupEntries fabricItemGroupEntries){
        fabricItemGroupEntries.add(DARKNESS_CAKE);
    }

    public static void registerModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemGroup);
        MarcoMod.LOGGER.info("Registering Items");
    }

}
