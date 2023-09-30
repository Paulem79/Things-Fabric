package fr.paulem.things.datagen.langs;

import fr.paulem.things.block.ModBlocks;
import fr.paulem.things.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class EnglishLangProvider extends FabricLanguageProvider {
    public EnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.ADAMANTIUM_INGOT, "Adamantium Ingot");
        translationBuilder.add(ModItems.RAW_ADAMANTIUM, "Raw Adamantium");

        translationBuilder.add(ModItems.TOMATO, "Tomato");
        translationBuilder.add(ModItems.TOMATO_SEEDS, "Tomato Seeds");

        translationBuilder.add(ModItems.COAL_BRIQUETTE, "Coal Briquette");

        translationBuilder.add(ModItems.METAL_DETECTOR, "Metal Detector");

        translationBuilder.add(ModItems.ADAMANTIUM_PICKAXE, "Adamantium Pickaxe");
        translationBuilder.add(ModItems.ADAMANTIUM_AXE, "Adamantium Axe");
        translationBuilder.add(ModItems.ADAMANTIUM_SHOVEL, "Adamantium Shovel");
        translationBuilder.add(ModItems.ADAMANTIUM_SWORD, "Adamantium Sword");
        translationBuilder.add(ModItems.ADAMANTIUM_HOE, "Adamantium Hoe");

        translationBuilder.add(ModItems.ADAMANTIUM_HELMET, "Adamantium Helmet");
        translationBuilder.add(ModItems.ADAMANTIUM_CHESTPLATE, "Adamantium Chestplate");
        translationBuilder.add(ModItems.ADAMANTIUM_LEGGINGS, "Adamantium Leggings");
        translationBuilder.add(ModItems.ADAMANTIUM_BOOTS, "Adamantium Boots");

        translationBuilder.add(ModBlocks.ADAMANTIUM_BLOCK, "Block of Adamantium");
        translationBuilder.add(ModBlocks.RAW_ADAMANTIUM_BLOCK, "Block of Raw Adamantium");

        translationBuilder.add(ModBlocks.ADAMANTIUM_ORE, "Adamantium Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE, "Deepslate Adamantium Ore");

        translationBuilder.add("itemgroup.things", "Things");

        translationBuilder.add("messages.things.found", "Found an ore at");
        translationBuilder.add("messages.things.not_found", "No ore found!");
    }
}