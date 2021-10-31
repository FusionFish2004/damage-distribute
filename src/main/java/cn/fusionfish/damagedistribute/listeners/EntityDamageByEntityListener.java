package cn.fusionfish.damagedistribute.listeners;

import cn.fusionfish.damagedistribute.DamageDistribute;
import cn.fusionfish.damagedistribute.handlers.DamageHandler;
import cn.fusionfish.damagedistribute.handlers.DamageHandlerFactory;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.jetbrains.annotations.NotNull;

public class EntityDamageByEntityListener implements Listener {

    @EventHandler
    public void onDamage(@NotNull EntityDamageByEntityEvent event) {

        if (!(event.getEntity() instanceof LivingEntity entity)) {
            return;
        }

        if (!entity.getWorld().equals(event.getDamager().getWorld())) {
            return;
        }

        DamageHandler handler = DamageHandlerFactory.getHandler(event);
        handler.handle();

    }
}
