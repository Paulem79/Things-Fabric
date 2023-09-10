package fr.paulem.things;

import fr.paulem.things.block.ThingsBlocks;
import fr.paulem.things.item.ThingsItemGroups;
import fr.paulem.things.item.ThingsItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Things implements ModInitializer {
	public static final String MOD_ID = "things";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ThingsItems.registerModItems();
		ThingsBlocks.registerModBlocks();

		ThingsItemGroups.registerItemGroups();
	}
}