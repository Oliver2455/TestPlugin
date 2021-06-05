package de.oliver2455.test.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("my.healcommand")) {
                player.setHealth(20);
                player.sendMessage(ChatColor.BLUE + "Du wurdest geheilt!");
            }else
            if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);
                if(target != null) {
                    if(player.hasPermission("my.healcommandtarget")) {
                        target.setHealth(20);
                        target.setFoodLevel(20);
                        target.sendMessage("Du wurdest geheilt!");
                        player.sendMessage(ChatColor.BLUE + "Du hast den Spieler "+ target + " Geheilt");
                    } else
                        player.sendMessage(ChatColor.RED + "Dafür hast nicht genügend Permissions");
                } else
                    player.sendMessage("Bitte benutze /heal <target>");
            } else
                player.sendMessage("Bitte benutze /heal <target>");

        }
        return false;
    }


}
