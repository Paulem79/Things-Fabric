package fr.paulem.things.item.armors;

import fr.paulem.things.Things;
import fr.paulem.things.item.ModToolMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    ADAMANTIUM("adamantium", 33, new int[] { 4, 8, 6, 4 }, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, 0.1f, ModToolMaterial.ADAMANTIUM.getRepairIngredientSupplier());

    /*
    LEATHER("leather", 5, new int[] { 1, 3, 2, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f),
    CHAIN("chainmail", 15, new int[] { 2, 5, 4, 1 }, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0f, 0.0f),
    IRON("iron", 15, new int[] { 2, 6, 5, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f),
    GOLD("gold", 7, new int[] { 2, 5, 3, 1 }, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0f, 0.0f),
    DIAMOND("diamond", 33, new int[] { 3, 8, 6, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, 0.0f),
    TURTLE("turtle", 25, new int[] { 2, 6, 5, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0f, 0.0f),
    NETHERITE("netherite", 37, new int[] { 3, 8, 6, 3 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0f, 0.1f);
     */

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float thougness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 15, 13 };

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float thougness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.thougness = thougness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return Things.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.thougness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
