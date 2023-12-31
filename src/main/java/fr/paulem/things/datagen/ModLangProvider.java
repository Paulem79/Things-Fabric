package fr.paulem.things.datagen;

import fr.paulem.things.datagen.langs.EnglishLangProvider;
import fr.paulem.things.datagen.langs.FrenchLangProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModLangProvider {
    public static void provideLangs(FabricDataGenerator.Pack pack){
        pack.addProvider(EnglishLangProvider::new);
        pack.addProvider(FrenchLangProvider::new);
    }
}
