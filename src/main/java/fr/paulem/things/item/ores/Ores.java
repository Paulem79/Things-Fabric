package fr.paulem.things.item.ores;

import fr.paulem.things.item.Initer;
import fr.paulem.things.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class Ores extends Initer {
    // ------------------- ADAMANTIUM -------------------
    public static final Item ADAMANTIUM_INGOT = ModItems.registerItem("adamantium_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_ADAMANTIUM = ModItems.registerItem("raw_adamantium", new Item(new FabricItemSettings()));

    @Override
    public void init() {
        super.init();
    }
}