package me.kelopy.teleportbow;

import me.kelopy.teleportbow.commands.giveBow;
import me.kelopy.teleportbow.listeners.bowListener;
import me.kelopy.teleportbow.listeners.playerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class TeleportBow extends JavaPlugin {

    private static TeleportBow instance;

    @Override
    public void onEnable() {
        System.out.println("Bows are teleporting...");

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        instance = this;

        getCommand("tpbow").setExecutor(new giveBow());
        getServer().getPluginManager().registerEvents(new bowListener(), this);
        getServer().getPluginManager().registerEvents(new playerJoin(), this);
    }

    public static TeleportBow getInstance(){
        return instance;
    }

}
