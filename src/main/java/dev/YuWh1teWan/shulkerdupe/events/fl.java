package dev.YuWh1teWan.shulkerdupe.events;

import dev.YuWh1teWan.shulkerdupe.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.material.Directional;

public class fl implements Listener {
    Main main;

    public fl(Main main) {
        this.main = main;
    }

    @EventHandler
    public void crash(BlockDispenseEvent event) {
        Block block = event.getBlock();
        if (block.getType() == Material.DISPENSER) {
            BlockFace blockFace = ((Directional)block.getState().getData()).getFacing();
            boolean bl = (block.getY() == block.getWorld().getMaxHeight() - 1 && blockFace == BlockFace.UP);
            boolean bl2 = (block.getY() == 0 && blockFace == BlockFace.DOWN);
            if ((bl2 || bl) && event.getItem().getType().name().toLowerCase().contains("shulker_box"))
                event.setCancelled(true);
        }
    }
}
