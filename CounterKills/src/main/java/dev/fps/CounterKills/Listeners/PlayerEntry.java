package dev.fps.CounterKills.Listeners;

import dev.fps.CounterKills.CounterKills;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerEntry implements Listener {
    private CounterKills plugin;

    public PlayerEntry (CounterKills plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        FileConfiguration config = plugin.getConfig();
        if(!config.contains("Player." + player.getUniqueId() + ".Kills")){
            config.set("Player." + player.getUniqueId() + ".Kills", 0);
            plugin.saveConfig();
        }
    }
}


