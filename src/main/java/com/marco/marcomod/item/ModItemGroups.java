package com.marco.marcomod.item;

import com.marco.marcomod.MarcoMod;
import com.marco.marcomod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> MARCOITEMS = register("marco_items");

    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MarcoMod.MOD_ID));
    }
    public static void regModItemGroups(){
        Registry.register(
                Registries.ITEM_GROUP,
                MARCOITEMS,
                ItemGroup.create(ItemGroup.Row.TOP,-1)
                        .displayName(Text.translatable("itemGroup.marcomod.marcoitems"))
                        .icon(() -> new ItemStack(ModItems.DARKNESS_CAKE))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.DARKNESS_CAKE);
                            entries.add(ModBlocks.MAGNET);
                        })
                        .build()
                        );
        MarcoMod.LOGGER.info("reg ModItemGroups");
    }
}
