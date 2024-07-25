package dev.YuWh1teWan.shulkerdupe.events;


import dev.YuWh1teWan.shulkerdupe.Main;
import dev.YuWh1teWan.shulkerdupe.util.FileUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class Dupe implements Listener {
    Main main;

    private HashMap<Player, Integer> count;

    public Dupe(Main main) {
        this.count = new HashMap<>();
        this.main = main;
    }

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (this.main.getConfig().getBoolean("ShulkerDupe") && FileUtil.getPlayerDataConfig().getBoolean(player.getName() + ".Dupe") && player.hasPermission("ShulkerDupe.use.dupe")) {
            this.count.putIfAbsent(player, Integer.valueOf(1));
            if (event.getBlock().getType().equals(Material.WHITE_SHULKER_BOX) || event
                    .getBlock().getType().equals(Material.ORANGE_SHULKER_BOX) || event
                    .getBlock().getType().equals(Material.PINK_SHULKER_BOX) || event
                    .getBlock().getType().equals(Material.LIGHT_BLUE_SHULKER_BOX) || event
                    .getBlock().getType().equals(Material.YELLOW_SHULKER_BOX) || event
                    .getBlock().getType().equals(Material.GREEN_SHULKER_BOX) || event
                    .getBlock().getType().equals(Material.SILVER_SHULKER_BOX) || event
                    .getBlock().getType().equals(Material.BLACK_SHULKER_BOX) || event
                    .getBlock().getType().equals(Material.BLUE_SHULKER_BOX) || event
                    .getBlock().getType().equals(Material.BROWN_SHULKER_BOX) || event
                    .getBlock().getType().equals(Material.CYAN_SHULKER_BOX) || event
                    .getBlock().getType().equals(Material.GRAY_SHULKER_BOX) || event
                    .getBlock().getType().equals(Material.LIME_SHULKER_BOX) || event
                    .getBlock().getType().equals(Material.MAGENTA_SHULKER_BOX) || event
                    .getBlock().getType().equals(Material.PURPLE_SHULKER_BOX) || event
                    .getBlock().getType().equals(Material.RED_SHULKER_BOX)) {
                if (FileUtil.getPlayerDataConfig().get(player.getName() + ".DupeCount") == null) {
                    FileUtil.getPlayerDataConfig().set(player.getName() + ".DupeCount", Integer.valueOf(1));
                    FileUtil.getPlayerDataConfig().set(player.getName() + ".Dupe", Boolean.valueOf(true));
                    FileUtil.getPlayerDataConfig().set(player.getName() + ".Notify", Boolean.valueOf(true));
                    FileUtil.save();
                }
                if (FileUtil.getPlayerDataConfig().getBoolean(player.getName() + ".Dupe")) {
                    this.count.put(player, Integer.valueOf(((Integer)this.count.get(player)).intValue() + 1));
                    if (((Integer)this.count.get(player)).intValue() == this.main.getConfig().getInt("ShulkerCounts") + 1) {
                        ItemStack box = new ItemStack(event.getBlock().getType());
                        ItemMeta boxMeta = event.getItemInHand().getItemMeta();
                        box.setItemMeta(boxMeta);
                        player.getInventory().addItem(new ItemStack[] { box });
                        this.count.put(player, Integer.valueOf(1));
                        FileUtil.getPlayerDataConfig().set(player.getName() + ".DupeCount", Integer.valueOf(FileUtil.getPlayerDataConfig().getInt(player.getName() + ".DupeCount") + 1));
                        FileUtil.save();
                        if (this.main.getConfig().getBoolean("Debug"))
                            this.main.getLogger().info(ChatColor.translateAlternateColorCodes('&', "&a") + player.getName());
                        if (this.main.getConfig().getBoolean("playerMessage") && FileUtil.getPlayerDataConfig().getBoolean(player.getName() + ".Notify"))
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a"));
                    }
                }
            }
        }
    }
}
