package gripe._90.pearlwithnochunk;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ThrownEnderpearl.class)
public abstract class ThrownEnderpearlMixin extends ThrowableItemProjectile {
    public ThrownEnderpearlMixin(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    /**
     * @reason Pre-21.3 behaviour of simply not sending any chunk-loading tickets from Ender Pearls in favour of
     * conventional modded chunk-loading solutions.
     * @author Ion "Căprioară" "Squirty McDork" Cutărescu
     */
    @Overwrite
    @Final
    @SuppressWarnings("resource")
    @Override
    public void tick() {
        if (getOwner() instanceof ServerPlayer player
                && !player.isAlive()
                && player.serverLevel().getGameRules().getBoolean(GameRules.RULE_ENDER_PEARLS_VANISH_ON_DEATH)) {
            discard();
        } else {
            super.tick();
        }
    }
}
