package fr.paulem.things.item.armors;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;

public class ArmorAndToolsRecipeContainer {
    public final SwordItem sword;
    public final PickaxeItem pickaxe;
    public final AxeItem axe;
    public final ShovelItem shovel;
    public final HoeItem hoe;
    public final ArmorItem helmet;
    public final ArmorItem chesplate;
    public final ArmorItem leggings;
    public final ArmorItem boots;
    public ArmorAndToolsRecipeContainer(SwordItem sword, PickaxeItem pickaxe, AxeItem axe, ShovelItem shovel,
                                        HoeItem hoe, ArmorItem helmet, ArmorItem chesplate, ArmorItem leggings, ArmorItem boots){
        this.sword = sword;
        this.pickaxe = pickaxe;
        this.axe = axe;
        this.shovel = shovel;
        this.hoe = hoe;
        this.helmet = helmet;
        this.chesplate = chesplate;
        this.leggings = leggings;
        this.boots = boots;
    }
}
