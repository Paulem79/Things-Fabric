package fr.paulem.things.item;

import fr.paulem.things.item.ores.Ores;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    ADAMANTIUM(MiningLevels.DIAMOND, 1861, 10.0f, 5.0f, 12, () -> Ingredient.ofItems(Ores.ADAMANTIUM_INGOT));

    /*
    WOOD(MiningLevels.WOOD, 59, 2.0f, 0.0f, 15),
    STONE(MiningLevels.STONE, 131, 4.0f, 1.0f, 5),
    IRON(MiningLevels.IRON, 250, 6.0f, 2.0f, 14),
    DIAMOND(MiningLevels.DIAMOND, 1561, 8.0f, 3.0f, 10),
    GOLD(MiningLevels.WOOD, 32, 12.0f, 0.0f, 22),
    NETHERITE(MiningLevels.NETHERITE, 2031, 9.0f, 4.0f, 15);
     */

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public Supplier<Ingredient> getRepairIngredientSupplier(){
        return this.repairIngredient;
    }
}
