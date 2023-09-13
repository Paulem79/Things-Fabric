package fr.paulem.things.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent TOMATO = new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.25f)
            .snack()
            .build();
}
