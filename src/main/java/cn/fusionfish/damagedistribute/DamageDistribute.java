package cn.fusionfish.damagedistribute;

import cn.fusionfish.damagedistribute.listeners.EntityDamageByEntityListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class DamageDistribute extends JavaPlugin {

    private static DamageDistribute instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
    }

    public static DamageDistribute getInstance() {
        return instance;
    }
    
}
