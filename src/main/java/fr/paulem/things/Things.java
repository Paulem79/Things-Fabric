package fr.paulem.things;

import fr.paulem.things.block.ModBlocks;
import fr.paulem.things.item.ModItemGroups;
import fr.paulem.things.item.ModItems;
import fr.paulem.things.item.fuels.Fuels;
import fr.paulem.things.util.ModLootTableModifiers;
import fr.paulem.things.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Things implements ModInitializer {
	public static final String MOD_ID = "things";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Identifier THINGS_AMBIANT_ID = new Identifier(MOD_ID + "things_ambiant");
	private static final SoundEvent SOUND_THINGS_AMBIANT = SoundEvent.of(THINGS_AMBIANT_ID); // remplacer le gen de minerai avec datagenerator

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

		ModLootTableModifiers.modifyLootTables();

		FuelRegistry.INSTANCE.add(Fuels.COAL_BRIQUETTE, 200);

		ModItemGroups.registerItemGroups();

		Registry.register(Registries.SOUND_EVENT, THINGS_AMBIANT_ID, SOUND_THINGS_AMBIANT);

		ModWorldGeneration.generateModWorldGen();
	}
}