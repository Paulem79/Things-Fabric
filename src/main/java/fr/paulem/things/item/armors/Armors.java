package fr.paulem.things.item.armors;

import fr.paulem.things.item.Initer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;

import static fr.paulem.things.item.ModItems.registerItem;

public class Armors extends Initer {
    // ------------------- ARMORS -------------------
    public static final EffectArmorItem ADAMANTIUM_HELMET = registerItem("adamantium_helmet", new EffectArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final ArmorItem ADAMANTIUM_CHESTPLATE = registerItem("adamantium_chestplate", new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final ArmorItem ADAMANTIUM_LEGGINGS = registerItem("adamantium_leggings", new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final ArmorItem ADAMANTIUM_BOOTS = registerItem("adamantium_boots", new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    @Override
    public void init() {
        super.init();
    }
}
