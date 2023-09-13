package fr.paulem.things.util;

import fr.paulem.things.Things;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> THINGS_ORES =
                createTag("things_ores");
        public static final TagKey<Block> THINGS_METAL_DETECTOR_DETECTABLE_BLOCKS =
                createTag("things_metal_detector_detectable_blocks");

        public static final TagKey<Block> THINGS_NOTFULLBLOCKS =
                createTag("things_notfullblocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Things.MOD_ID, name));
        }
    }

    public static class Items {


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Things.MOD_ID, name));
        }
    }
}
