package me.kelopy.teleportbow.utility;

import me.kelopy.teleportbow.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class bowUtils {

    public static ItemStack createTeleportBow(){

        ItemStack bow = new ItemStack(Material.BOW, 1);
        bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);

        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', TeleportBow.getInstance().getConfig().getString("bow-name")));
        bowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bowMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        bowMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        bowMeta.setUnbreakable(true);

        List<String> lore = new ArrayList<>();
        for(String bowLore : TeleportBow.getInstance().getConfig().getStringList("bow-lore")){
            lore.add(ChatColor.translateAlternateColorCodes('&', bowLore));
        }

        bowMeta.setLore(lore);
        bow.setItemMeta(bowMeta);

        return bow;
    }

}
