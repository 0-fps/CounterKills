package dev.fps.CounterKills;

import dev.fps.CounterKills.Commands.ReloadCMD;
import dev.fps.CounterKills.Listeners.PlayerEntry;
import dev.fps.CounterKills.Listeners.PlayerKillZombies;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class CounterKills extends JavaPlugin {

    public String ConfigRute;


    public void onEnable(){
        registerListeners();
        registerConfig();
        Bukkit.getConsoleSender().sendMessage("CounterKills has been enabled");

    }
    public void onDisable(){
        Bukkit.getConsoleSender().sendMessage("CounterKills has been disabled");
    }


    public void registerListeners(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerKillZombies(this), this);
        pm.registerEvents(new PlayerEntry(this), this);
    }
    public void registerConfig(){
        File config = new File(this.getDataFolder(),"config.yml");
        ConfigRute = config.getPath();
        if(!config.exists()){
            this.getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }
}
