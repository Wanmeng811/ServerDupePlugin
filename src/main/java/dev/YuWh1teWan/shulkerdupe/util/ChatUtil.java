package dev.YuWh1teWan.shulkerdupe.util;

import org.bukkit.ChatColor;

public class ChatUtil {
    public static String color(String Message) {
        return ChatColor.translateAlternateColorCodes('&', Message);
    }

    public static String prefix() {
        return color("&9[&eShulker&d&lDupe&9]");
    }

    public static String noPrem() {
        return prefix() + color(" &c");
    }
}
