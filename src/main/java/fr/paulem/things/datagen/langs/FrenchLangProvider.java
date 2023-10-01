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

public class FrenchLangProvider extends FabricLanguageProvider {
    public FrenchLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "fr_fr");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(Ores.ADAMANTIUM_INGOT, "Lingot d'adamantium");
        translationBuilder.add(Ores.RAW_ADAMANTIUM, "Adamantium Brut");

        translationBuilder.add(Foods.TOMATO, "Tomate");
        translationBuilder.add(Seeds.TOMATO_SEEDS, "Graines de tomate");

        translationBuilder.add(Fuels.COAL_BRIQUETTE, "Fragment de charbon");

        translationBuilder.add(Customs.METAL_DETECTOR, "Détecteur de métaux");

        translationBuilder.add(Tools.ADAMANTIUM_PICKAXE, "Pioche en adamantium");
        translationBuilder.add(Tools.ADAMANTIUM_AXE, "Hache en adamantium");
        translationBuilder.add(Tools.ADAMANTIUM_SHOVEL, "Pelle en adamantium");
        translationBuilder.add(Tools.ADAMANTIUM_SWORD, "Épée en adamantium");
        translationBuilder.add(Tools.ADAMANTIUM_HOE, "Houe en adamantium");

        translationBuilder.add(Armors.ADAMANTIUM_HELMET, "Casque en adamantium");
        translationBuilder.add(Armors.ADAMANTIUM_CHESTPLATE, "Plastron en adamantium");
        translationBuilder.add(Armors.ADAMANTIUM_LEGGINGS, "Jambières en adamantium");
        translationBuilder.add(Armors.ADAMANTIUM_BOOTS, "Bottes en adamantium");

        translationBuilder.add(ModBlocks.ADAMANTIUM_BLOCK, "Bloc d'adamantium");
        translationBuilder.add(ModBlocks.RAW_ADAMANTIUM_BLOCK, "Block en adamantium brut");

        translationBuilder.add(ModBlocks.ADAMANTIUM_ORE, "Minerai d'adamantium");
        translationBuilder.add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE, "Minerai d'adamantium des abîmes");

        translationBuilder.add("itemgroup.things", "Things");

        translationBuilder.add("messages.things.found", "Minerai trouvé en");
        translationBuilder.add("messages.things.not_found", "Pas de minerai trouvé !");

        translationBuilder.add(EnchantHandler.EXPLODE.getTranslationKey(), "Explosion");
        translationBuilder.add(EnchantHandler.EXPLODE.getTranslationKey() + ".desc", "Créer une explosion lorsqu'un monstre est frappé.");
    }
}