package fr.paulem.things.item.tools;

import fr.paulem.things.item.Initer;
import fr.paulem.things.item.ModItems;
import fr.paulem.things.item.ModToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;

public class Tools extends Initer {
    // ------------------- TOOLS -------------------
    public static final SwordItem ADAMANTIUM_SWORD = ModItems.registerItem("adamantium_sword", new SwordItem(ModToolMaterial.ADAMANTIUM, 3, -2.4f, new FabricItemSettings()));
    public static final PickaxeItem ADAMANTIUM_PICKAXE = ModItems.registerItem("adamantium_pickaxe", new PickaxeItem(ModToolMaterial.ADAMANTIUM, 1, -2.8f, new FabricItemSettings()));
    public static final AxeItem ADAMANTIUM_AXE = ModItems.registerItem("adamantium_axe", new AxeItem(ModToolMaterial.ADAMANTIUM, 5, -3.0f, new FabricItemSettings()));
    public static final ShovelItem ADAMANTIUM_SHOVEL = ModItems.registerItem("adamantium_shovel", new ShovelItem(ModToolMaterial.ADAMANTIUM, 1.5f, -3.0f, new FabricItemSettings()));
    public static final HoeItem ADAMANTIUM_HOE = ModItems.registerItem("adamantium_hoe", new HoeItem(ModToolMaterial.ADAMANTIUM, -3, 0.0f, new FabricItemSettings()));

    @Override
    public void init() {
        super.init();
    }
}