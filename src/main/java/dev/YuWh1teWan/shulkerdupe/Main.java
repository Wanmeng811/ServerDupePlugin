package dev.YuWh1teWan.shulkerdupe;

import dev.YuWh1teWan.shulkerdupe.commands.CommandBase;
import dev.YuWh1teWan.shulkerdupe.events.Dupe;
import dev.YuWh1teWan.shulkerdupe.events.fl;
import dev.YuWh1teWan.shulkerdupe.util.FileUtil;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getCommand("sd").setExecutor(new CommandBase());
        FileUtil.setup();
        FileUtil.getPlayerDataConfig().options().copyDefaults(true);
        FileUtil.save();
        getServer().getPluginManager().registerEvents((Listener)new Dupe(this), (Plugin)this);
        getServer().getPluginManager().registerEvents((Listener)new fl(this), (Plugin)this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
