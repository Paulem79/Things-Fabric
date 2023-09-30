package fr.paulem.things.util;

import fr.paulem.things.item.custom.Customs;
import fr.paulem.things.item.fuels.Fuels;
import fr.paulem.things.item.seeds.Seeds;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifiers {
    private static final Identifier JUNGLE_TEMPLE_ID = new Identifier("minecraft", "chests/jungle_temple");
    private static final Identifier CREEPER_ID = new Identifier("minecraft", "entities/creeper");
    private static final Identifier SUSPICIOUS_SAND_ID = new Identifier("minecraft", "archaeology/desert_pyramid");
    private static final Identifier GRASS_ID = new Identifier("minecraft", "blocks/grass");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(JUNGLE_TEMPLE_ID.equals(id))
                createPool(tableBuilder, 1, 90, Customs.METAL_DETECTOR, 1.0f, 1.0f);

            if(CREEPER_ID.equals(id))
                createPool(tableBuilder, 1, 25, Fuels.COAL_BRIQUETTE, 1.0f, 1.0f);

            if(GRASS_ID.equals(id))
                createPool(tableBuilder, 1, 5, Seeds.TOMATO_SEEDS, 1.0f, 2.0f);
        });

        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if(SUSPICIOUS_SAND_ID.equals(id))
                return addSusSandItems(original, Customs.METAL_DETECTOR);

            return null;
        });
    }

    public static LootTable addSusSandItems(LootTable original, ItemConvertible... items) {
        List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
        entries.addAll(Arrays.stream(items).map(i -> ItemEntry.builder(i).build()).toList());

        LootPool.Builder pool = LootPool.builder().with(entries);
        return LootTable.builder().pool(pool).build();
    }

    public static LootPool createPool(int rolls, float chance, ItemConvertible item, float minAmount, float maxAmount) {
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(rolls))
                .conditionally(RandomChanceLootCondition.builder(chance/100))
                .with(ItemEntry.builder(item))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minAmount, maxAmount)).build()).build();
    }

    public static LootTable.Builder createPool(LootTable.Builder tableBuilder, int rolls, float chance, ItemConvertible item, float minAmount, float maxAmount) {
        return tableBuilder.pool(createPool(rolls, chance, item, minAmount, maxAmount));
    }
}
