package com.marco.marcomod.block;

import com.marco.marcomod.MarcoMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block MAGNET = register("magnet",new MagnetBlock(AbstractBlock.Settings.create().requiresTool().strength(3.0f,3.0f)));
    public static void regBksItem(String id,Block block){   //注册方块物品
        Item item = Registry.register(Registries.ITEM,Identifier.of(MarcoMod.MOD_ID,id),new BlockItem(block,new Item.Settings()));
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }

    public static Block register(String id, Block block) {   //注册方块
        regBksItem(id,block);
        return Registry.register(Registries.BLOCK, Identifier.of(MarcoMod.MOD_ID,id), block);
    }

    public static void regModBlocks(){
        MarcoMod.LOGGER.info("reg ModBlocks");
    }
}
