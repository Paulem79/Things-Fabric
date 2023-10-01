package fr.paulem.things.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Explode extends Enchantment {
    public Explode() {
        super(Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 10*level;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity) {
            ItemStack mainItem = user.getMainHandStack();
            ItemStack offItem = user.getOffHandStack();
            if(EnchantmentHelper.getLevel(Enchantments.FIRE_ASPECT, mainItem) >= 1 ||
                    EnchantmentHelper.getLevel(Enchantments.FIRE_ASPECT, offItem) >= 1)
                target.getWorld().createExplosion(user, target.getX(), target.getY(), target.getZ(), 2f*level, true, World.ExplosionSourceType.NONE);
            else
                target.getWorld().createExplosion(user, target.getX(), target.getY(), target.getZ(), 2f*level, World.ExplosionSourceType.NONE);
        }

        super.onTargetDamaged(user, target, level);
    }
}
