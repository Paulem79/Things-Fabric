package fr.paulem.things.item.seeds;

import fr.paulem.things.block.ModBlocks;
import fr.paulem.things.item.Initer;
import fr.paulem.things.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;

public class Seeds extends Initer {
    // ------------------- SEEDS -------------------
    public static final Item TOMATO_SEEDS = ModItems.registerItem("tomato_seeds",
            new AliasedBlockItem(ModBlocks.TOMATO_CROP, new FabricItemSettings()));

    @Override
    public void init() {
        super.init();
    }
}