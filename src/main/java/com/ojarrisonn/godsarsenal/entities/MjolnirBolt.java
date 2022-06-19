package com.ojarrisonn.godsarsenal.entities;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class MjolnirBolt extends ThrowableProjectile {
    public MjolnirBolt(EntityType<? extends ThrowableProjectile> p_37466_, Level p_37467_) {
        super(p_37466_, p_37467_);
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity target = pResult.getEntity();
        Level level = target.getLevel();
        if (!level.isClientSide()) {
            LightningBolt lb = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            lb.copyPosition(target);
            level.addFreshEntity(lb);
            //this.kill();
        }
    }
}
