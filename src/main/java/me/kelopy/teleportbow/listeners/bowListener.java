package me.kelopy.teleportbow.listeners;

import me.kelopy.teleportbow.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class bowListener implements Listener {

    @EventHandler
    public void onArrowLand(ProjectileHitEvent e) {

        if (e.getEntity().getShooter() instanceof Player p) {
            ItemStack itemInMainHand = p.getInventory().getItemInMainHand();

            if(itemInMainHand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', TeleportBow.getInstance().getConfig().getString("bow-name")))){
                Location location = e.getEntity().getLocation();
                float pitch = p.getLocation().getPitch();
                float yaw = p.getLocation().getYaw();

                location.setPitch(pitch);
                location.setYaw(yaw);

                p.teleport(location);
                e.getEntity().remove();
                p.playSound(location, Sound.BLOCK_NOTE_PLING, 1.0f, 1.0f);
                if(TeleportBow.getInstance().getConfig().getBoolean("tp-message")){
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', TeleportBow.getInstance().getConfig().getString("message")));
                }
            }

        }

    }

}
