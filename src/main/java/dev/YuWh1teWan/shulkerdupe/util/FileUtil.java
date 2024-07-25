package dev.YuWh1teWan.shulkerdupe.util;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileUtil {
    private static File playerData;

    public static FileConfiguration playerDataConf;

    public static void setup() {
        playerData = new File(Bukkit.getServer().getPluginManager().getPlugin("ShulkerDupe").getDataFolder(), "playerData.yml");
        if (!playerData.exists())
            try {
                playerData.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        playerDataConf = (FileConfiguration)YamlConfiguration.loadConfiguration(playerData);
    }

    public static FileConfiguration getPlayerDataConfig() {
        return playerDataConf;
    }

    public static void save() {
        try {
            playerDataConf.save(playerData);
        } catch (IOException ovo) {
            ovo.printStackTrace();
        }
    }
}
