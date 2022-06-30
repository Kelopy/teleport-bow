package me.kelopy.teleportbow.commands;

import me.kelopy.teleportbow.utility.bowUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class giveBow implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            if(args.length == 0){
                ItemStack bow = bowUtils.createTeleportBow();
                p.getInventory().addItem(bow);
                p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                String msg = "&7You have given yourself &bTeleport Bow&7!";
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }else{
                Player target = Bukkit.getPlayerExact(args[0]);

                if(target == null){
                    p.sendMessage(ChatColor.RED + "Player not found.");
                }else{
                    if(p.hasPermission("tpbow.others")){
                        ItemStack bow = bowUtils.createTeleportBow();
                        target.getInventory().addItem(bow);
                        target.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                        String msgOthers = "&7You have been given a &bTeleport Bow &7by &b" + p.getDisplayName() + "&7!";
                        target.sendMessage(ChatColor.translateAlternateColorCodes('&', msgOthers));
                    }
                }

            }

        }else{
            System.out.println("This command can only be executed by a player.");
        }

        return true;
    }

}
