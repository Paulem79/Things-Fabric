package fr.paulem.things.datagen.langs;

import fr.paulem.things.block.ModBlocks;
import fr.paulem.things.enchants.EnchantHandler;
import fr.paulem.things.item.armors.Armors;
import fr.paulem.things.item.custom.Customs;
import fr.paulem.things.item.food.Foods;
import fr.paulem.things.item.fuels.Fuels;
import fr.paulem.things.item.ores.Ores;
import fr.paulem.things.item.seeds.Seeds;
import fr.paulem.things.item.tools.Tools;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class EnglishLangProvider extends FabricLanguageProvider {
    public EnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(Ores.ADAMANTIUM_INGOT, "Adamantium Ingot");
        translationBuilder.add(Ores.RAW_ADAMANTIUM, "Raw Adamantium");

        translationBuilder.add(Foods.TOMATO, "Tomato");
        translationBuilder.add(Seeds.TOMATO_SEEDS, "Tomato Seeds");

        translationBuilder.add(Fuels.COAL_BRIQUETTE, "Coal Briquette");

        translationBuilder.add(Customs.METAL_DETECTOR, "Metal Detector");

        translationBuilder.add(Tools.ADAMANTIUM_PICKAXE, "Adamantium Pickaxe");
        translationBuilder.add(Tools.ADAMANTIUM_AXE, "Adamantium Axe");
        translationBuilder.add(Tools.ADAMANTIUM_SHOVEL, "Adamantium Shovel");
        translationBuilder.add(Tools.ADAMANTIUM_SWORD, "Adamantium Sword");
        translationBuilder.add(Tools.ADAMANTIUM_HOE, "Adamantium Hoe");

        translationBuilder.add(Armors.ADAMANTIUM_HELMET, "Adamantium Helmet");
        translationBuilder.add(Armors.ADAMANTIUM_CHESTPLATE, "Adamantium Chestplate");
        translationBuilder.add(Armors.ADAMANTIUM_LEGGINGS, "Adamantium Leggings");
        translationBuilder.add(Armors.ADAMANTIUM_BOOTS, "Adamantium Boots");

        translationBuilder.add(ModBlocks.ADAMANTIUM_BLOCK, "Block of Adamantium");
        translationBuilder.add(ModBlocks.RAW_ADAMANTIUM_BLOCK, "Block of Raw Adamantium");

        translationBuilder.add(ModBlocks.ADAMANTIUM_ORE, "Adamantium Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE, "Deepslate Adamantium Ore");

        translationBuilder.add("itemgroup.things", "Things");

        translationBuilder.add("messages.things.found", "Found an ore at");
        translationBuilder.add("messages.things.not_found", "No ore found!");

        translationBuilder.add(EnchantHandler.EXPLODE.getTranslationKey(), "Explosion");
        translationBuilder.add(EnchantHandler.EXPLODE.getTranslationKey() + ".desc", "Create an explosion when a mob is hit.");

        translationBuilder.add("tooltip.things.metal_detector", "Find ores by right clicking.");
    }
}