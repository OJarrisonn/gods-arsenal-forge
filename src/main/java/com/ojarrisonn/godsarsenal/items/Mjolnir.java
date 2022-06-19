package com.ojarrisonn.godsarsenal.items;

import com.ojarrisonn.godsarsenal.entities.MjolnirBolt;
import com.ojarrisonn.godsarsenal.entities.ModEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.phys.Vec3;

import java.util.Objects;

public class Mjolnir extends SwordItem {
    public Mjolnir() {
        super(Tiers.NETHERITE, 10, -3.0f, new Item.Properties().tab(ModItemTabs.GODS_ARSENAL_TAB).stacksTo(1).rarity(Rarity.EPIC).setNoRepair());
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            Level level = pContext.getLevel();
            Vec3 pos = pContext.getClickLocation();
            LightningBolt lb1 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            LightningBolt lb2 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            LightningBolt lb3 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            lb1.setPos(pos);
            lb2.setPos(pos);
            lb3.setPos(pos);
            level.addFreshEntity(lb1);
            level.addFreshEntity(lb2);
            level.addFreshEntity(lb3);
            Objects.requireNonNull(pContext.getPlayer()).clearFire();

            return InteractionResult.SUCCESS;
        }
        return super.useOn(pContext);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (!player.getLevel().isClientSide()) {
            Level level = player.getLevel();
            LightningBolt lb1 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            LightningBolt lb2 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            LightningBolt lb3 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            lb1.copyPosition(entity);
            lb2.copyPosition(entity);
            lb3.copyPosition(entity);
            level.addFreshEntity(lb1);
            level.addFreshEntity(lb2);
            level.addFreshEntity(lb3);
            player.clearFire();
            return true;
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide && pPlayer.getUseItem().is(ModItems.MJOLNIR.get())) {
            MjolnirBolt bolt = new MjolnirBolt(ModEntityTypes.MJOLNIR_BOLT.get(), pLevel);
            bolt.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0f, 5f, 0.1f);
            pLevel.addFreshEntity(bolt);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public boolean doesSneakBypassUse(ItemStack stack, LevelReader level, BlockPos pos, Player player) {
        return false;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
}
