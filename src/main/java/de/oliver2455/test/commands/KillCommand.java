package de.oliver2455.test.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (sender.hasPermission("my.killcommand")) {
                player.setHealth(0);
                player.sendMessage("Du hast dich selber gekillt");
            } else if (args.length == 0) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    target.setHealth(0);
                    target.sendMessage("Du wurdest von " + player + "gekillt");

                } else
                    sender.sendMessage("Der player " + target + "ist nicht online");

            }
        }
        return false;
    }
}
