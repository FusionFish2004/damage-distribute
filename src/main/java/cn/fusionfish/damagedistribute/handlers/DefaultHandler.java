package cn.fusionfish.damagedistribute.handlers;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.jetbrains.annotations.NotNull;

public class DefaultHandler extends DamageHandler {
    public DefaultHandler(@NotNull EntityDamageByEntityEvent event) {
        super(event);
    }

    @Override
    public void handle() {

    }
}
