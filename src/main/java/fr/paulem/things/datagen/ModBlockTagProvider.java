package fr.paulem.things.datagen;

import fr.paulem.things.block.ModBlocks;
import fr.paulem.things.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        // ------------------- CUSTOM TAGS -------------------

        /*getOrCreateTagBuilder(ModTags.Blocks.THINGS_NOTFULLBLOCKS)
                .add(ModBlocks.RUBY_WALL)
                .add(ModBlocks.RUBY_FENCE_GATE)
                .add(ModBlocks.RUBY_FENCE)
                .add(ModBlocks.RUBY_BUTTON)
                .add(ModBlocks.RUBY_TRAPDOOR)
                .add(ModBlocks.RUBY_DOOR)
                .add(ModBlocks.RUBY_STAIRS)
                .add(ModBlocks.RUBY_SLAB)
                .add(ModBlocks.RUBY_PRESSURE_PLATE);*/

        getOrCreateTagBuilder(ModTags.Blocks.THINGS_ORES)
                .add(ModBlocks.ADAMANTIUM_ORE)
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);
                /*.add(ModBlocks.NETHER_RUBY_ORE)
                .add(ModBlocks.END_STONE_RUBY_ORE);*/


        getOrCreateTagBuilder(ModTags.Blocks.THINGS_METAL_DETECTOR_DETECTABLE_BLOCKS)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(ModTags.Blocks.THINGS_ORES);

        // ------------------- BLOCKS BREAK -------------------

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(ModTags.Blocks.THINGS_ORES)
                //.forceAddTag(ModTags.Blocks.THINGS_NOTFULLBLOCKS)
                .add(ModBlocks.ADAMANTIUM_BLOCK)
                .add(ModBlocks.RAW_ADAMANTIUM_BLOCK);


        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                //.add(ModBlocks.NETHER_RUBY_ORE)
                .add(ModBlocks.ADAMANTIUM_ORE)
                .add(ModBlocks.RAW_ADAMANTIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ADAMANTIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);
                //.forceAddTag(ModTags.Blocks.THINGS_NOTFULLBLOCKS);
                //.add(ModBlocks.END_STONE_RUBY_ORE);

        /*getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.RUBY_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.RUBY_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.RUBY_WALL);*/

        // For custom tool level
        /*
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(xxx);
        */
    }
}
