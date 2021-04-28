package dev.fps.CounterKills.Commands;

import dev.fps.CounterKills.CounterKills;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCMD implements CommandExecutor {

    private CounterKills plugin;

    public ReloadCMD(CounterKills plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command commands, String label, String[] args) {
        Player player = (Player) sender;
        if(args.length > 0){
            if(args[0].equalsIgnoreCase("reload")){
                plugin.reloadConfig();
                player.sendMessage(ChatColor.GREEN+"CounterKill reloaded successfully");
            }
        }
        return true;
    }
}
