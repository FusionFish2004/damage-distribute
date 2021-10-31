package cn.fusionfish.damagedistribute.handlers;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.jetbrains.annotations.NotNull;

public abstract class DamageHandler {

    private final LivingEntity entity;
    private final EntityDamageByEntityEvent event;

    public DamageHandler(@NotNull EntityDamageByEntityEvent event) {
        this.entity = (LivingEntity) event.getEntity();
        this.event = event;
    }

    public abstract void handle();

    protected final LivingEntity getEntity() {
        return entity;
    }

    protected final EntityDamageByEntityEvent getEvent() {
        return event;
    }
}
