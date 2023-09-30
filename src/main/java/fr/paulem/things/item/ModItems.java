package fr.paulem.things.item;

import fr.paulem.things.Things;
import fr.paulem.things.item.armors.Armors;
import fr.paulem.things.item.custom.Customs;
import fr.paulem.things.item.food.Foods;
import fr.paulem.things.item.fuels.Fuels;
import fr.paulem.things.item.ores.Ores;
import fr.paulem.things.item.seeds.Seeds;
import fr.paulem.things.item.tools.Tools;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<ItemStack> items = new ArrayList<>();

    public static <T extends Item> T registerItem(String name, T item) {
        items.add(item.getDefaultStack());
        return Registry.register(Registries.ITEM, new Identifier(Things.MOD_ID, name), item);
    }

    public static void registerModItems() {
        new Armors().init();
        new Customs().init();
        new Foods().init();
        new Fuels().init();
        new Ores().init();
        new Seeds().init();
        new Tools().init();
        Things.LOGGER.info("Registering mod items for " + Things.MOD_ID);
    }
}
