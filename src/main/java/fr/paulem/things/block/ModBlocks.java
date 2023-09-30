package fr.paulem.things.block;

import fr.paulem.things.Things;
import fr.paulem.things.block.custom.crops.TomatoCropBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<ItemStack> blocks = new ArrayList<>();


    // ------------------- ORES BLOCKS -------------------
    public static final Block ADAMANTIUM_BLOCK = registerBlock("adamantium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_ADAMANTIUM_BLOCK = registerBlock("raw_adamantium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    // ------------------- ORES -------------------
    public static final Block ADAMANTIUM_ORE = registerBlock("adamantium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2, 5)));
    public static final Block DEEPSLATE_ADAMANTIUM_ORE = registerBlock("deepslate_adamantium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f), UniformIntProvider.create(2, 5)));
    /*public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).strength(1.5f), UniformIntProvider.create(1, 3)));
    public static final Block END_STONE_RUBY_ORE = registerBlock("end_stone_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).strength(3f), UniformIntProvider.create(4, 7)));*/

    // ------------------- CUSTOM BLOCKS -------------------
    //public static final Block SOUND_BLOCK = registerBlock("sound_block", new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    // ------------------- NOT BLOCKS -------------------
    /*public static final Block RUBY_STAIRS = registerBlock("ruby_stairs", new StairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE_STAIRS).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RUBY_SLAB = registerBlock("ruby_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_SLAB).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RUBY_BUTTON = registerBlock("ruby_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BUTTON).sounds(BlockSoundGroup.AMETHYST_BLOCK), BlockSetType.ACACIA, 10, true));
    public static final Block RUBY_PRESSURE_PLATE = registerBlock("ruby_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.STONE_PRESSURE_PLATE).sounds(BlockSoundGroup.AMETHYST_BLOCK), BlockSetType.ACACIA));
    public static final Block RUBY_FENCE = registerBlock("ruby_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_FENCE).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RUBY_FENCE_GATE = registerBlock("ruby_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_FENCE_GATE).sounds(BlockSoundGroup.AMETHYST_BLOCK), WoodType.ACACIA));
    public static final Block RUBY_WALL = registerBlock("ruby_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RUBY_DOOR = registerBlock("ruby_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR).sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque(), BlockSetType.ACACIA));
    public static final Block RUBY_TRAPDOOR = registerBlock("ruby_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_TRAPDOOR).sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque(), BlockSetType.ACACIA));*/

    public static final Block TOMATO_CROP = registerBlock("tomato_crop",
            new TomatoCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)), false);















    public static Block registerBlock(String name, Block block) {
        return registerBlock(name, block, true);
    }

    public static Block registerBlock(String name, Block block, boolean registerItem) {
        if(registerItem) blocks.add(registerBlockItem(name, block).getDefaultStack());
        return Registry.register(Registries.BLOCK, new Identifier(Things.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Things.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Things.LOGGER.info("Registering mod blocks for " + Things.MOD_ID);
    }
}
