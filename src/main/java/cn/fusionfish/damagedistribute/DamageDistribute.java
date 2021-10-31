package cn.fusionfish.damagedistribute;

import cn.fusionfish.damagedistribute.listeners.EntityDamageByEntityListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class DamageDistribute extends JavaPlugin {

    private static DamageDistribute instance;
    public final File CONFIG_FILE = new File(getDataFolder(), "config.yml");

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);

        if (!getDataFolder().exists()) {
            boolean result = getDataFolder().mkdir();
            if (!result) {
                Bukkit.getPluginManager().disablePlugin(this);
            }
        }

        if (!CONFIG_FILE.exists()) {
            saveDefaultConfig();
        }
    }

    public static DamageDistribute getInstance() {
        return instance;
    }

}
