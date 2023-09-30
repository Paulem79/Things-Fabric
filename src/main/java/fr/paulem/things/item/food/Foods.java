package fr.paulem.things.item.food;

import fr.paulem.things.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class Foods {
    // ------------------- FOODS -------------------
    public static final Item TOMATO = ModItems.registerItem("tomato", new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
}
