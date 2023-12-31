package fr.paulem.things.item;

import fr.paulem.things.Things;
import fr.paulem.things.block.ModBlocks;
import fr.paulem.things.item.ores.Ores;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup THINGS_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Things.MOD_ID, "things"), FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.things"))
            .icon(() -> new ItemStack(Ores.ADAMANTIUM_INGOT))
            .entries((displayContext, entries) -> {
                entries.addAll(ModItems.items);

                entries.addAll(ModBlocks.blocks);
    }).build());

    public static void registerItemGroups() {
        Things.LOGGER.info("Registering item groups for " + Things.MOD_ID);
    }
}
