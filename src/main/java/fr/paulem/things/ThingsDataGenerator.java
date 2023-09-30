package fr.paulem.things;

import fr.paulem.things.datagen.ModBlockTagProvider;
import fr.paulem.things.datagen.ModItemTagProvider;
import fr.paulem.things.datagen.ModLangProvider;
import fr.paulem.things.datagen.ModLootTableProvider;
import fr.paulem.things.datagen.ModModelProvider;
import fr.paulem.things.datagen.ModRecipeProvider;
import fr.paulem.things.datagen.ModWorldGenerator;
import fr.paulem.things.world.ModConfiguredFeatures;
import fr.paulem.things.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class ThingsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModWorldGenerator::new);
		ModLangProvider.provideLangs(pack);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}
