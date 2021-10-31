package cn.fusionfish.damagedistribute.handlers;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.jetbrains.annotations.NotNull;

public class DamageHandlerFactory {
    public static DamageHandler getHandler(@NotNull EntityDamageByEntityEvent event) {
        return switch (event.getCause()) {
            case ENTITY_ATTACK -> new MeleeHandler(event);
            case PROJECTILE -> new ProjectileHandler(event);
            default -> new DefaultHandler(event);
        };
    }
}
