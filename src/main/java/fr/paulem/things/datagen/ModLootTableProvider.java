package fr.paulem.things.datagen;

import fr.paulem.things.block.ModBlocks;
import fr.paulem.things.block.custom.crops.TomatoCropBlock;
import fr.paulem.things.item.ModItems;
import fr.paulem.things.item.food.Foods;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ADAMANTIUM_BLOCK);
        addDrop(ModBlocks.RAW_ADAMANTIUM_BLOCK);

        sameDropWithSilkTouch(ModBlocks.ADAMANTIUM_ORE, ModItems.RAW_ADAMANTIUM);
        //sameDropWithSilkTouch(ModBlocks.NETHER_RUBY_ORE, ModItems.RAW_ADAMANTIUM);
        sameDropWithSilkTouch(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE, ModItems.RAW_ADAMANTIUM);
        //sameDropWithSilkTouch(ModBlocks.END_STONE_RUBY_ORE, ModItems.RAW_ADAMANTIUM);

        /*addDrop(ModBlocks.RUBY_BUTTON);
        addDrop(ModBlocks.RUBY_FENCE);
        addDrop(ModBlocks.RUBY_FENCE_GATE);
        addDrop(ModBlocks.RUBY_PRESSURE_PLATE);
        addDrop(ModBlocks.RUBY_STAIRS);
        addDrop(ModBlocks.RUBY_TRAPDOOR);
        addDrop(ModBlocks.RUBY_WALL);

        addDrop(ModBlocks.RUBY_DOOR, doorDrops(ModBlocks.RUBY_DOOR));
        addDrop(ModBlocks.RUBY_SLAB, slabDrops(ModBlocks.RUBY_SLAB));*/

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(TomatoCropBlock.AGE, 5));
        addDrop(ModBlocks.TOMATO_CROP, cropDrops(ModBlocks.TOMATO_CROP, Foods.TOMATO, ModItems.TOMATO_SEEDS, builder));
    }

    public void sameDropWithSilkTouch(Block block, Item drop) {
        addDrop(block, oreDrops(block, drop));
    }

    @SuppressWarnings("all")
    public LootTable.Builder copperLikeOreDrops(Block drop, Item item, float minDrop, float maxDrop) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop, ((LeafEntry.Builder)
                ItemEntry.builder(item)
                        .apply(SetCountLootFunction
                                .builder(UniformLootNumberProvider
                                        .create(minDrop, maxDrop))))
                .apply(ApplyBonusLootFunction
                        .oreDrops(Enchantments.FORTUNE))));
    }
}
