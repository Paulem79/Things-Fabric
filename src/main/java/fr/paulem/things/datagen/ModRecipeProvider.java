package fr.paulem.things.datagen;

import fr.paulem.things.block.ModBlocks;
import fr.paulem.things.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY,
            ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE,
            ModBlocks.NETHER_RUBY_ORE, ModBlocks.END_STONE_RUBY_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f, 100, "ruby");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.DECORATIONS, ModBlocks.RUBY_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_RUBY, RecipeCategory.DECORATIONS, ModBlocks.RAW_RUBY_BLOCK);

        createShapelessRecipe(RecipeCategory.MISC, ModItems.COAL_BRIQUETTE, 8, Items.COAL, exporter);

        createShapelessRecipe(RecipeCategory.MISC, Items.COAL, ModItems.COAL_BRIQUETTE, 8, exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_BUTTON, 4)
                .input(ModItems.RUBY, 1)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .group("ruby")
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_BUTTON)));

        createFenceRecipe(ModBlocks.RUBY_FENCE, Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .group("ruby")
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_FENCE)));
        createFenceGateRecipe(ModBlocks.RUBY_FENCE_GATE, Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .group("ruby")
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_FENCE_GATE)));
        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_PRESSURE_PLATE, Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .group("ruby")
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_PRESSURE_PLATE)));
        createStairsRecipe(ModBlocks.RUBY_STAIRS, Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .group("ruby")
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_STAIRS)));
        createTrapdoorRecipe(ModBlocks.RUBY_TRAPDOOR, Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .group("ruby")
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_TRAPDOOR)));
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_WALL, ModItems.RUBY);
        createDoorRecipe(ModBlocks.RUBY_DOOR, Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .group("ruby")
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_DOOR)));
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_SLAB, Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .group("ruby")
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_SLAB)));

        createToolsRecipe(ModItems.RUBY, exporter, "ruby",
                ModItems.RUBY_SWORD,
                ModItems.RUBY_PICKAXE,
                ModItems.RUBY_AXE,
                ModItems.RUBY_SHOVEL,
                ModItems.RUBY_HOE);

        /*createSwordRecipe(ModItems.RUBY_SWORD, ModItems.RUBY, exporter, "ruby");
        createAxeRecipe(ModItems.RUBY_AXE, ModItems.RUBY, exporter, "ruby");
        createPickaxeRecipe(ModItems.RUBY_PICKAXE, ModItems.RUBY, exporter, "ruby");
        createShovelRecipe(ModItems.RUBY_SHOVEL, ModItems.RUBY, exporter, "ruby");
        createHoeRecipe(ModItems.RUBY_HOE, ModItems.RUBY, exporter, "ruby");*/
    }

    /**
     *
     * @param requiredItem The required ore
     * @param exporter The exporter
     * @param group The group of the recipe
     * @param tools ORDER : sword, pickaxe, axe, shovel, hoe
     */
    public static void createToolsRecipe(ItemConvertible requiredItem, Consumer<RecipeJsonProvider> exporter, String group, ItemConvertible... tools) {
        createSwordRecipe(tools[0], requiredItem, exporter, group);
        createPickaxeRecipe(tools[1], requiredItem, exporter, group);
        createAxeRecipe(tools[2], requiredItem, exporter, group);
        createShovelRecipe(tools[3], requiredItem, exporter, group);
        createHoeRecipe(tools[4], requiredItem, exporter, group);
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
