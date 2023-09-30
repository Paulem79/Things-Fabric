package fr.paulem.things.mixin;

import fr.paulem.things.item.food.Foods;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ComposterBlock.class)
public class ComposterBlockMixin {
    @Inject(method = "registerDefaultCompostableItems", at = @At("TAIL"))
    private static void registerDefaultCompostableItems(CallbackInfo ci) {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(Foods.TOMATO, 0.65f);
    }

    @ModifyArg(method = "emptyFullComposter", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ItemEntity;<init>(Lnet/minecraft/world/World;DDDLnet/minecraft/item/ItemStack;)V"), index = 4)
    private static ItemStack moreBoneMeal(ItemStack stack) {
        return new ItemStack(Items.BONE_MEAL, 3);
    }
}