package fr.paulem.things.item.armors;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class EffectArmorItem extends ArmorItem {
    private static final List<ArmorEffects> ARMOR_EFFECTS = List.of(
            new ArmorEffects(ModArmorMaterials.ADAMANTIUM,
                    new StatusEffectInstance(StatusEffects.HASTE, -1, 0, false, false, true),
                    new StatusEffectInstance(StatusEffects.HEALTH_BOOST, -1, 0, false, false, true))
    );

    public static class ArmorEffects {
        private final ArmorMaterial material;
        private final List<StatusEffectInstance> effects;

        public ArmorEffects(ArmorMaterial material, StatusEffectInstance... effects){
            this.material = material;
            this.effects = List.of(effects);
        }

        public ArmorMaterial getMaterial() {
            return material;
        }

        public List<StatusEffectInstance> getEffects() {
            return effects;
        }
    }

    public EffectArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                evaluateArmorEffects(player);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (ArmorEffects entry : ARMOR_EFFECTS) {
            ArmorMaterial mapArmorMaterial = entry.getMaterial();
            List<StatusEffectInstance> mapStatusEffect = entry.getEffects();

            addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, List<StatusEffectInstance> mapStatusEffect) {
        boolean hasEffect = player.getStatusEffects().containsAll(mapStatusEffect);
        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasEffect)
            for (StatusEffectInstance statusEffect : mapStatusEffect){
                player.addStatusEffect(new StatusEffectInstance(statusEffect));
            }
        else if(!hasCorrectArmorOn(mapArmorMaterial, player) && hasEffect)
            for (StatusEffectInstance statusEffect : mapStatusEffect){
                player.removeStatusEffect(statusEffect.getEffectType());
            }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !chestplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        for (ItemStack armorStack: player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
