package fr.paulem.things.item.armors;

import fr.paulem.things.util.armor.ModArmorItem;
import fr.paulem.things.util.armor.ModArmorMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;

import static fr.paulem.things.item.ModItems.registerItem;

public class Armors {
    // ------------------- ARMORS -------------------
    public static final ModArmorItem ADAMANTIUM_HELMET = registerItem("adamantium_helmet", new ModArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final ArmorItem ADAMANTIUM_CHESTPLATE = registerItem("adamantium_chestplate", new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final ArmorItem ADAMANTIUM_LEGGINGS = registerItem("adamantium_leggings", new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final ArmorItem ADAMANTIUM_BOOTS = registerItem("adamantium_boots", new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));
}
