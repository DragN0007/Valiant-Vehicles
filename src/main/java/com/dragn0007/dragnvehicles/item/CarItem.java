package com.dragn0007.dragnvehicles.item;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class CarItem extends Item {

    public CarItem() {
        super(new Properties().tab(CreativeModeTab.TAB_TRANSPORTATION));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        BlockHitResult blockHitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);

        if(blockHitResult.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(itemStack);
        } else if (level.isClientSide) {
            return InteractionResultHolder.success(itemStack);
        } else {
            BlockPos pos = blockHitResult.getBlockPos();
            if(level.getBlockState(pos).getBlock() instanceof LiquidBlock) {
                return InteractionResultHolder.pass(itemStack);
            } else if (level.mayInteract(player, pos) && player.mayUseItemAt(pos, blockHitResult.getDirection(), itemStack)) {
                Tractor tractor = (Tractor) LittleTractorMain.TRACTOR.get().spawn((ServerLevel) level, itemStack, player, pos.above(), MobSpawnType.SPAWN_EGG, false, false);
                if(tractor == null) {
                    return InteractionResultHolder.pass(itemStack);
                } else {
                    if(!player.getAbilities().instabuild) {
                        itemStack.shrink(1);
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    level.gameEvent(GameEvent.ENTITY_PLACE, player);
                    return InteractionResultHolder.consume(itemStack);
                }
            } else {
                return InteractionResultHolder.fail(itemStack);
            }
        }
    }
}
