package fr.paulem.things;

import fr.paulem.things.block.ModBlocks;
import fr.paulem.things.item.ModItemGroups;
import fr.paulem.things.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Things implements ModInitializer {
	public static final String MOD_ID = "things";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);

		ModItemGroups.registerItemGroups();
	}
}