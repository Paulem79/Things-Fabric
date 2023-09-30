package fr.paulem.things.item.fuels;

import fr.paulem.things.item.Initer;
import fr.paulem.things.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class Fuels extends Initer {
    // ------------------- FUELS -------------------
    public static final Item COAL_BRIQUETTE = ModItems.registerItem("coal_briquette", new Item(new FabricItemSettings()));

    @Override
    public void init() {
        super.init();
    }
}