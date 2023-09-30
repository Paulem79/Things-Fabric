package fr.paulem.things.item.custom;

import fr.paulem.things.item.Initer;
import fr.paulem.things.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class Customs extends Initer {
    // ------------------- CUSTOM ITEMS -------------------
    public static final ItemMetalDetector METAL_DETECTOR = ModItems.registerItem("metal_detector", new ItemMetalDetector(new FabricItemSettings().maxCount(1).maxDamage(60)));

    @Override
    public void init() {
        super.init();
    }
}
