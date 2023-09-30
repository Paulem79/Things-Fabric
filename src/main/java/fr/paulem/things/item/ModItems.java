package fr.paulem.things.item;

import fr.paulem.things.Things;
import fr.paulem.things.block.ModBlocks;
import fr.paulem.things.item.custom.ItemMetalDetector;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<ItemStack> items = new ArrayList<>();


    // ------------------- RUBY -------------------
    public static final Item ADAMANTIUM_INGOT = registerItem("adamantium_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_ADAMANTIUM = registerItem("raw_adamantium", new Item(new FabricItemSettings()));


    // ------------------- FUELS -------------------
    public static final Item COAL_BRIQUETTE = registerItem("coal_briquette", new Item(new FabricItemSettings()));


    // ------------------- CUSTOM ITEMS -------------------
    public static final ItemMetalDetector METAL_DETECTOR = registerItem("metal_detector", new ItemMetalDetector(new FabricItemSettings().maxCount(1).maxDamage(60)));

    // ------------------- TOOLS -------------------
    public static final SwordItem ADAMANTIUM_SWORD = registerItem("adamantium_sword", new SwordItem(ModToolMaterial.ADAMANTIUM, 3, -2.4f, new FabricItemSettings()));
    public static final PickaxeItem ADAMANTIUM_PICKAXE = registerItem("adamantium_pickaxe", new PickaxeItem(ModToolMaterial.ADAMANTIUM, 1, -2.8f, new FabricItemSettings()));
    public static final AxeItem ADAMANTIUM_AXE = registerItem("adamantium_axe", new AxeItem(ModToolMaterial.ADAMANTIUM, 5, -3.0f, new FabricItemSettings()));
    public static final ShovelItem ADAMANTIUM_SHOVEL = registerItem("adamantium_shovel", new ShovelItem(ModToolMaterial.ADAMANTIUM, 1.5f, -3.0f, new FabricItemSettings()));
    public static final HoeItem ADAMANTIUM_HOE = registerItem("adamantium_hoe", new HoeItem(ModToolMaterial.ADAMANTIUM, -3, 0.0f, new FabricItemSettings()));


    // ------------------- SEEDS -------------------
    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new AliasedBlockItem(ModBlocks.TOMATO_CROP, new FabricItemSettings()));



















    public static <T extends Item> T registerItem(String name, T item) {
        items.add(item.getDefaultStack());
        return Registry.register(Registries.ITEM, new Identifier(Things.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Things.LOGGER.info("Registering mod items for " + Things.MOD_ID);
    }
}
