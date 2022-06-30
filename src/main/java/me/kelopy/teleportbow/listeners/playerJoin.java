package me.kelopy.teleportbow.listeners;

import me.kelopy.teleportbow.TeleportBow;
import me.kelopy.teleportbow.utility.bowUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class playerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        if(TeleportBow.getInstance().getConfig().getBoolean("give-bow-on-join") && !p.hasPlayedBefore()){
                p.getInventory().addItem(bowUtils.createTeleportBow());
                p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }

    }

}
