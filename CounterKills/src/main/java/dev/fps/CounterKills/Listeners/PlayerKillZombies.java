package dev.fps.CounterKills.Listeners;


import dev.fps.CounterKills.CounterKills;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;


public class PlayerKillZombies implements Listener {

    private CounterKills plugin;

    public PlayerKillZombies(CounterKills plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void counterKill(EntityDeathEvent event){
        FileConfiguration config = plugin.getConfig();
        EntityType entity = event.getEntityType();
        Player player = event.getEntity().getKiller();
        if(player != null && entity.equals(EntityType.ZOMBIE) && player.getType().equals(EntityType.PLAYER)){
            int kills = config.getInt("Player." + player.getUniqueId() + ".Kills");
            config.set("Player."+player.getUniqueId()+".Kills", kills+1);
            plugin.saveConfig();
            player.sendMessage("Has matado."+kills+" Zombies.");
        }

    }
}
