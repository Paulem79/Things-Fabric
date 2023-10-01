package fr.paulem.things.enchants;

import fr.paulem.things.Things;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EnchantHandler {
    public static final Enchantment EXPLODE = Registry.register(Registries.ENCHANTMENT, new Identifier(Things.MOD_ID, "explode"), new Explode());

    public static void init(){
        Things.LOGGER.info("Registering enchants");
    }
}