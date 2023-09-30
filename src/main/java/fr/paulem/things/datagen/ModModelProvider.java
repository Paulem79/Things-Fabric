package fr.paulem.things.datagen;

import fr.paulem.things.block.ModBlocks;
import fr.paulem.things.block.custom.crops.TomatoCropBlock;
import fr.paulem.things.item.armors.Armors;
import fr.paulem.things.item.custom.Customs;
import fr.paulem.things.item.food.Foods;
import fr.paulem.things.item.fuels.Fuels;
import fr.paulem.things.item.ores.Ores;
import fr.paulem.things.item.tools.Tools;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //BlockStateModelGenerator.BlockTexturePool rubyPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ADAMANTIUM_BLOCK);
        // Ou bien
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ADAMANTIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_ADAMANTIUM_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ADAMANTIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);

        /*blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_RUBY_ORE);

        rubyPool.stairs(ModBlocks.RUBY_STAIRS);
        rubyPool.slab(ModBlocks.RUBY_SLAB);
        rubyPool.button(ModBlocks.RUBY_BUTTON);
        rubyPool.pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE);
        rubyPool.fence(ModBlocks.RUBY_FENCE);
        rubyPool.fenceGate(ModBlocks.RUBY_FENCE_GATE);
        rubyPool.wall(ModBlocks.RUBY_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.RUBY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.RUBY_TRAPDOOR);*/

        blockStateModelGenerator.registerCrop(ModBlocks.TOMATO_CROP, TomatoCropBlock.AGE, 0, 1, 2, 3, 4, 5);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(Ores.ADAMANTIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(Ores.RAW_ADAMANTIUM, Models.GENERATED);

        itemModelGenerator.register(Fuels.COAL_BRIQUETTE, Models.GENERATED);
        itemModelGenerator.register(Foods.TOMATO, Models.GENERATED);
        itemModelGenerator.register(Customs.METAL_DETECTOR, Models.GENERATED);

        itemModelGenerator.register(Tools.ADAMANTIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(Tools.ADAMANTIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(Tools.ADAMANTIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(Tools.ADAMANTIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(Tools.ADAMANTIUM_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(Armors.ADAMANTIUM_HELMET);
        itemModelGenerator.registerArmor(Armors.ADAMANTIUM_CHESTPLATE);
        itemModelGenerator.registerArmor(Armors.ADAMANTIUM_LEGGINGS);
        itemModelGenerator.registerArmor(Armors.ADAMANTIUM_BOOTS);
    }
}
