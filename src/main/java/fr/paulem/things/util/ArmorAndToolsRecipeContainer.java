package fr.paulem.things.util;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;

public class ArmorAndToolsRecipeContainer {
    public SwordItem sword;
    public PickaxeItem pickaxe;
    public AxeItem axe;
    public ShovelItem shovel;
    public HoeItem hoe;
    public ArmorItem helmet, chesplate, leggings, boots;
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
