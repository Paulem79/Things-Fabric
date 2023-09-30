package fr.paulem.things.item.custom;

import fr.paulem.things.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemMetalDetector extends Item {
    public ItemMetalDetector(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        if (player == null) return ActionResult.PASS;
        if(context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            boolean foundBlock = false;

            BlockPos pos = null;

            for (int i = positionClicked.getY(); i >= -63; i--) {
                BlockPos blockPos = positionClicked.down(Math.abs(i - positionClicked.getY()));
                BlockState state = context.getWorld().getBlockState(blockPos);

                if (isValuableBlock(state)) {
                    foundBlock = true;
                    pos = blockPos;

                    break;
                }
            }

            if (!foundBlock) player.sendMessage(Text.translatable("messages.things.not_found"));
            else
                player.sendMessage(Text.translatable("messages.things.found").append(" " + pos.getX() + ", " + pos.getY() + ", " + pos.getZ()));
        }

        context.getStack().damage(1, player, playerEntity -> playerEntity.sendToolBreakStatus(context.getHand()));

        return ActionResult.SUCCESS;
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.THINGS_METAL_DETECTOR_DETECTABLE_BLOCKS);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.things.metal_detector"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
