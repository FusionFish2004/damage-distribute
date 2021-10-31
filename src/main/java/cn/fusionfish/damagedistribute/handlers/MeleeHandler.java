package cn.fusionfish.damagedistribute.handlers;

import cn.fusionfish.damagedistribute.DamageDistribute;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class MeleeHandler extends DamageHandler {
    public MeleeHandler(@NotNull EntityDamageByEntityEvent event) {
        super(event);
    }

    @Override
    public void handle() {

        final double range = 5;
        //玩家近战范围
        final LivingEntity entity = getEntity();
        final EntityDamageByEntityEvent event = getEvent();

        if (!(event.getDamager() instanceof final Player player)) {
            return;
        }

        Vector direction = player.getLocation().getDirection();
        Location eyeLocation = player.getLocation().clone().add(0,player.getEyeHeight(),0);

        World world = player.getWorld();
        RayTraceResult result = world.rayTrace(eyeLocation, direction, range, FluidCollisionMode.NEVER, false, 0, e -> !e.equals(player));

        if (result == null) return;

        if (result.getHitEntity() == null) return;

        final FileConfiguration config = DamageDistribute.getInstance().getConfig();


        double hitY = result.getHitPosition().getY();
        double entityEyesY = entity.getEyeHeight() + entity.getLocation().getY();

        if (Math.abs(hitY - entityEyesY) <= 0.25) {
            event.setDamage(50);
        }
    }
}
