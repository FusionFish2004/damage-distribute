package cn.fusionfish.damagedistribute.handlers;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class ProjectileHandler extends DamageHandler {
    public ProjectileHandler(@NotNull EntityDamageByEntityEvent event) {
        super(event);
    }

    @Override
    public void handle() {

        final LivingEntity entity = getEntity();
        final EntityDamageByEntityEvent event = getEvent();
        if (!(event.getDamager() instanceof final Projectile projectile)) {
            return;
        }

        if (!(projectile.getShooter() instanceof Player player)) {
            return;
        }

        double hitY = projectile.getLocation().getY();
        double entityEyesY = entity.getEyeHeight() + entity.getLocation().getY();

        if (Math.abs(hitY - entityEyesY) <= 0.25) {
            event.setDamage(50);
        }

    }
}
