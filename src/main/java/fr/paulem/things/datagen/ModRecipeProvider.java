package fr.paulem.things.datagen;

import fr.paulem.things.block.ModBlocks;
import fr.paulem.things.item.ModItems;
import fr.paulem.things.item.armors.Armors;
import fr.paulem.things.util.armor.ArmorAndToolsRecipeContainer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> ADAMANTIUM_SMELTABLES = List.of(ModItems.RAW_ADAMANTIUM,
            ModBlocks.ADAMANTIUM_ORE, ModBlocks.DEEPSLATE_ADAMANTIUM_ORE
            //ModBlocks.NETHER_RUBY_ORE, ModBlocks.END_STONE_RUBY_ORE
            );

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, ADAMANTIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ADAMANTIUM_INGOT,
                0.7f, 200, "adamantium");
        offerBlasting(exporter, ADAMANTIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ADAMANTIUM_INGOT,
                0.7f, 100, "adamantium");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ADAMANTIUM_INGOT, RecipeCategory.DECORATIONS, ModBlocks.ADAMANTIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_ADAMANTIUM, RecipeCategory.DECORATIONS, ModBlocks.RAW_ADAMANTIUM_BLOCK);

        createShapelessRecipe(RecipeCategory.MISC, ModItems.COAL_BRIQUETTE, 8, Items.COAL, exporter);

        createShapelessRecipe(RecipeCategory.MISC, Items.COAL, ModItems.COAL_BRIQUETTE, 8, exporter);

        /*ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_BUTTON, 4)
                .input(ModItems.ADAMANTIUM_INGOT, 1)
                .criterion(hasItem(ModItems.ADAMANTIUM_INGOT), conditionsFromItem(ModItems.ADAMANTIUM_INGOT))
                .group("ruby")
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_BUTTON)));

        createFenceRecipe(ModBlocks.RUBY_FENCE, Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT))
                .criterion(hasItem(ModItems.ADAMANTIUM_INGOT), conditionsFromItem(ModItems.ADAMANTIUM_INGOT))
                .group("ruby")
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_FENCE)));
        createFenceGateRecipe(ModBlocks.RUBY_FENCE_GATE, Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT))
                .criterion(hasItem(ModItems.ADAMANTIUM_INGOT), conditionsFromItem(ModItems.ADAMANTIUM_INGOT))
                .group("ruby")
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_FENCE_GATE)));
        offerPressurePlateRecipe(exporter, ModBlocks.RUBY_PRESSURE_PLATE, ModItems.ADAMANTIUM_INGOT);
        createStairsRecipe(ModBlocks.RUBY_STAIRS, Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT))
                .criterion(hasItem(ModItems.ADAMANTIUM_INGOT), conditionsFromItem(ModItems.ADAMANTIUM_INGOT))
                .group("ruby")
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_STAIRS)));
        createTrapdoorRecipe(ModBlocks.RUBY_TRAPDOOR, Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT))
                .criterion(hasItem(ModItems.ADAMANTIUM_INGOT), conditionsFromItem(ModItems.ADAMANTIUM_INGOT))
                .group("ruby")
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_TRAPDOOR)));
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_WALL, ModItems.ADAMANTIUM_INGOT);
        createDoorRecipe(ModBlocks.RUBY_DOOR, Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT))
                .criterion(hasItem(ModItems.ADAMANTIUM_INGOT), conditionsFromItem(ModItems.ADAMANTIUM_INGOT))
                .group("ruby")
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_DOOR)));
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_SLAB, ModItems.ADAMANTIUM_INGOT);*/

        createToolsAndArmorsRecipe(ModItems.ADAMANTIUM_INGOT, exporter, "adamantium", new ArmorAndToolsRecipeContainer(
                ModItems.ADAMANTIUM_SWORD,
                ModItems.ADAMANTIUM_PICKAXE,
                ModItems.ADAMANTIUM_AXE,
                ModItems.ADAMANTIUM_SHOVEL,
                ModItems.ADAMANTIUM_HOE,
                Armors.ADAMANTIUM_HELMET,
                Armors.ADAMANTIUM_CHESTPLATE,
                Armors.ADAMANTIUM_LEGGINGS,
                Armors.ADAMANTIUM_BOOTS));
    }

    /**
     *
     * @param requiredItem The required ore
     * @param exporter The exporter
     * @param group The group of the recipe
     * @param container ORDER : sword, pickaxe, axe, shovel, hoe, helmet, chesplate, leggings, boots
     */
    public static void createToolsAndArmorsRecipe(ItemConvertible requiredItem, Consumer<RecipeJsonProvider> exporter, String group, ArmorAndToolsRecipeContainer container) {
        createSwordRecipe(container.sword, requiredItem, exporter, group);
        createPickaxeRecipe(container.pickaxe, requiredItem, exporter, group);
        createAxeRecipe(container.axe, requiredItem, exporter, group);
        createShovelRecipe(container.shovel, requiredItem, exporter, group);
        createHoeRecipe(container.hoe, requiredItem, exporter, group);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, container.helmet)
                .pattern("RRR")
                .pattern("R R")
                .input('R', requiredItem)
                .criterion(hasItem(requiredItem), conditionsFromItem(requiredItem))
                .group(group)
                .offerTo(exporter, new Identifier(getRecipeName(container.helmet)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, container.chesplate)
                .pattern("R R")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', requiredItem)
                .criterion(hasItem(requiredItem), conditionsFromItem(requiredItem))
                .group(group)
                .offerTo(exporter, new Identifier(getRecipeName(container.chesplate)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, container.leggings)
                .pattern("RRR")
                .pattern("R R")
                .pattern("R R")
                .input('R', requiredItem)
                .criterion(hasItem(requiredItem), conditionsFromItem(requiredItem))
                .group(group)
                .offerTo(exporter, new Identifier(getRecipeName(container.leggings)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, container.boots)
                .pattern("R R")
                .pattern("R R")
                .input('R', requiredItem)
                .criterion(hasItem(requiredItem), conditionsFromItem(requiredItem))
                .group(group)
                .offerTo(exporter, new Identifier(getRecipeName(container.boots)));
    }

    public static void createHoeRecipe(ItemConvertible output, ItemConvertible requiredItem, Consumer<RecipeJsonProvider> exporter, String group){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("RR")
                .pattern("S ")
                .pattern("S ")
                .input('R', requiredItem)
                .input('S', Items.STICK)
                .criterion(hasItem(requiredItem), conditionsFromItem(requiredItem))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .group(group)
                .offerTo(exporter, new Identifier(getRecipeName(output)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("RR")
                .pattern(" S")
                .pattern(" S")
                .input('R', requiredItem)
                .input('S', Items.STICK)
                .criterion(hasItem(requiredItem), conditionsFromItem(requiredItem))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .group(group)
                .offerTo(exporter, new Identifier(getRecipeName(output) + "_inverted"));
    }

    public static void createShovelRecipe(ItemConvertible output, ItemConvertible requiredItem, Consumer<RecipeJsonProvider> exporter, String group){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("R")
                .pattern("S")
                .pattern("S")
                .input('R', requiredItem)
                .input('S', Items.STICK)
                .criterion(hasItem(requiredItem), conditionsFromItem(requiredItem))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .group(group)
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }

    public static void createPickaxeRecipe(ItemConvertible output, ItemConvertible requiredItem, Consumer<RecipeJsonProvider> exporter, String group){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("RRR")
                .pattern(" S ")
                .pattern(" S ")
                .input('R', requiredItem)
                .input('S', Items.STICK)
                .criterion(hasItem(requiredItem), conditionsFromItem(requiredItem))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .group(group)
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }

    public static void createAxeRecipe(ItemConvertible output, ItemConvertible requiredItem, Consumer<RecipeJsonProvider> exporter, String group){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("RR")
                .pattern("SR")
                .pattern("S ")
                .input('R', requiredItem)
                .input('S', Items.STICK)
                .criterion(hasItem(requiredItem), conditionsFromItem(requiredItem))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .group(group)
                .offerTo(exporter, new Identifier(getRecipeName(output)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("RR")
                .pattern("RS")
                .pattern(" S")
                .input('R', requiredItem)
                .input('S', Items.STICK)
                .criterion(hasItem(requiredItem), conditionsFromItem(requiredItem))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .group(group)
                .offerTo(exporter, new Identifier(getRecipeName(output) + "_inverted"));
    }

    public static void createSwordRecipe(ItemConvertible output, ItemConvertible requiredItem, Consumer<RecipeJsonProvider> exporter, String group){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("R")
                .pattern("R")
                .pattern("S")
                .input('R', requiredItem)
                .input('S', Items.STICK)
                .criterion(hasItem(requiredItem), conditionsFromItem(requiredItem))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .group(group)
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }

    public static void createShapelessRecipe(RecipeCategory recipeCategory, ItemConvertible output, Item input, Consumer<RecipeJsonProvider> exporter){
        createShapelessRecipe(recipeCategory, output, 1, input, 1, exporter);
    }

    public static void createShapelessRecipe(RecipeCategory recipeCategory, ItemConvertible output, Item input, int inputCount, Consumer<RecipeJsonProvider> exporter){
        createShapelessRecipe(recipeCategory, output, 1, input, inputCount, exporter);
    }

    public static void createShapelessRecipe(RecipeCategory recipeCategory, ItemConvertible output, int outputCount, Item input, Consumer<RecipeJsonProvider> exporter){
        createShapelessRecipe(recipeCategory, output, outputCount, input, 1, exporter);
    }

    public static void createShapelessRecipe(RecipeCategory recipeCategory, ItemConvertible output, int outputCount, Item input, int inputCount, Consumer<RecipeJsonProvider> exporter){
        ShapelessRecipeJsonBuilder.create(recipeCategory, output, outputCount)
                .input(input, inputCount)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
}
